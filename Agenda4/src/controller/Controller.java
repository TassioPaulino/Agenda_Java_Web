package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.Document;

import model.Connectable;
import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = {"/Controller", "/main", "/adcionar", "/select", "/editar", "/delete", "/report"})
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	private Connectable dao = new DAO();
	
	/** The contato. */
	private JavaBeans contato = new JavaBeans();
    
    /**
     * Instantiates a new controller.
     */
    public Controller() {
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		if(action.equals("/main")) {
			abrirAgenda(request, response);
		} else if (action.equals("/adcionar")) {
			adcionarContato(request, response);
		} else if (action.equals("/select")) {
			selecionarContato(request, response);
		} else if (action.equals("/editar")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			deletarContato(request, response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);
		}
	}

	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		new Relatorio().gerarRelatorio(response);
	}

	/**
	 * Deletar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void deletarContato(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		dao.deletarContato(request.getParameter("idcon"));
		response.sendRedirect("main");
	}

	/**
	 * Editar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		dao.editarContato(contato);
		response.sendRedirect("main");
	}

	/**
	 * Selecionar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void selecionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		contato = dao.selecionarContato(request.getParameter("idcon"));
		request.setAttribute("contato", contato);
		RequestDispatcher rs = request.getRequestDispatcher("editor.jsp");
		rs.forward(request, response);
	}

	/**
	 * Adcionar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void adcionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String nome = request.getParameter("nome");
		String fone = request.getParameter("fone");
		String email = request.getParameter("email");
		contato.setNome(nome);
		contato.setFone(fone);
		contato.setEmail(email);
		dao.inserirNovoContato(contato);
		response.sendRedirect("main");
	}

	/**
	 * Abrir agenda.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void abrirAgenda(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarContatos();
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

}

