package com.famadev.controller;

import com.famadev.domain.Cargo;
import com.famadev.domain.Departamento;
import com.famadev.service.CargoService;
import com.famadev.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cargos")
public class CargoController {
    // injecao de dados
    @Autowired
    private CargoService cargoService;

    @Autowired
    private DepartamentoService departamentoService;

    // metodos
    @GetMapping("/cadastrar")
    public String cadastrar(Cargo cargo) {
        return "/cargo/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        // enviando Cargos para pagina
        model.addAttribute("cargos", cargoService.buscarTodos());
        return "/cargo/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Cargo cargo, RedirectAttributes attr) {
        cargoService.salvar(cargo);
        attr.addFlashAttribute("success", "Cargo salvo com sucesso.");
        // retorno para pagina de cadastro
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("cargo", cargoService.buscarPorId(id));
        return "/cargo/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Cargo cargo, RedirectAttributes attr) {
        cargoService.editar(cargo);
        attr.addFlashAttribute("success", "Cargo editado com sucesso.");
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        if (cargoService.cargoTemFuncionarios(id)) {
            model.addAttribute("fail", "Cargo não foi removido. A funcionario(s) vinculados");
        }
        else {
            cargoService.excluir(id);
            model.addAttribute("success", "Cargo excluido com sucesso.");
        }
        // Retorno chamando o metodo listar
        // pode fazer um redirect para /departamentos/listar
        return listar(model);
    }

    // enviando lista de departamentos para pagina de cadastro
    @ModelAttribute("departamentos")
    public List<Departamento> listaDeDepartamentos(){
        return departamentoService.buscarTodos();
    }
}
