package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * input画面表示クラス
*/
@WebServlet("/input")
public class SampleInputController extends HttpServlet {

	private static final String SAMPLE_STR = "もじれつ";
	private static final String ENCODE = "UTF-8";
	
	/**
	 * 画面表示
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException, IOException
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("str", SAMPLE_STR); //文字列を渡してみる
		request.setAttribute("strMap", getStrMap()); //mapもついでに渡してみる
		
		request.getRequestDispatcher("/input.jsp").forward(request, response);
	}
	
	/**
	 * POSTで受け取ったものを別のサーブレット(SampleOutputController)へ渡してから
	 * フォワードしてみる
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException, IOException
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストのエンコーディングを指定
		request.setCharacterEncoding(ENCODE);
		
		final String name = request.getParameter("name");
		final String email = request.getParameter("email");
		final String opinion = request.getParameter("opinion");
		
		// リクエストスコープに格納してSampleOutputControllerで受け取れるようにする
		request.setAttribute("nameForOutput", name);
		request.setAttribute("emailForOutput", email);
		request.setAttribute("opinionForOutput", opinion);
		
		// 転送オブジェクトを取得
		RequestDispatcher RequestDispatcher = request.getRequestDispatcher("output");
		
		RequestDispatcher.forward(request, response);
	}
	
	private HashMap<Integer, String> getStrMap() {
		
		final HashMap<Integer, String> map = new HashMap<>();
		map.put(0, "1番目");
		map.put(1, "2番目");
		map.put(2, "3番目");
		
		return map;
		
	}
}
