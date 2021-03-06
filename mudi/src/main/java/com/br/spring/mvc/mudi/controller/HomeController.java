package com.br.spring.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.spring.mvc.mudi.model.Pedido;
import com.br.spring.mvc.mudi.model.StatusPedido;
import com.br.spring.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;	
	
	@GetMapping
	public String home(Model model) {			

		/*
		final BigDecimal valor = new BigDecimal("331.95");

		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Echo Dot (3ª Geração): Smart Speaker com Alexa - Cor Preta");
		pedido.setValorNegociado(valor);
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/41GZCWFJB1L._AC_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/Echo-Dot-3%C2%AA-Gera%C3%A7%C3%A3o-Cor-Preta/dp/B07PDHSJ1H/ref=sr_1_1?crid=J3YEMLLF9K99&dchild=1&keywords=Alexa+Echo&nav_sdd=aps&qid=1634409429&sprefix=alexa&sr=8-1&ufe=app_do%3Aamzn1.fos.95de73c3-5dda-43a7-bd1f-63af03b14751");
		pedido.setDescricao("Produto vendido e entregue por AMAZON do Brasil");
		pedido.setDataEntrega(LocalDate.of(2021, 10, 25));

		List<Pedido> pedidos = Arrays.asList(pedido);
		*/
		
		// pedidos.add(pedido);
		
		List<Pedido> pedidos = pedidoRepository.findAll();

		model.addAttribute("pedidos", pedidos);

		return "home";
	}
	
	@GetMapping("/{status}")
	public String aguardando(@PathVariable("status") String status, Model model) {	
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));

		model.addAttribute("pedidos", pedidos);

		return "home";
		}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onErros() {
		
		return "redirect:/home";
	}
}
