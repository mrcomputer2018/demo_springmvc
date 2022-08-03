package com.famadev.controller;

import com.famadev.domain.Departamento;
import com.famadev.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
    // atributo
    // Para poder acessar oos metodos de service
    @Autowired
    private DepartamentoService service;

    @GetMapping("/cadastrar")
    public String cadastrar(Departamento departamento) {
        return "/departamento/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        // criando variavel que envia lista para página
        model.addAttribute("departamentos", service.buscarTodos());
        return"/departamento/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) {
        if(result.hasErrors()){
            return "departamento/cadastro";
        }

        service.salvar(departamento);
        attr.addFlashAttribute("success", "Departamento salvo com sucesso.");
        // retorno para pagina de cadastro
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("departamento", service.buscarPorId(id));
        return "/departamento/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()){
            return "/departamento/cadastro";
        }

        service.editar(departamento);
        attr.addFlashAttribute("success", "Departamento editado com sucesso.");
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        // Se nao tem cargos eh feita a exclusão
        if (service.departamentosTemCargos(id)) {
            model.addAttribute("fail", "Departamento não foi removido. A cargo(s) vinculados");
        } else {
            service.excluir(id);
            model.addAttribute("success", "Departamento removido.");
        }
        // Retorno chamando o metodo listar
        // pode fazer um redirect para /departamentos/listar
        return listar(model);
    }
}
