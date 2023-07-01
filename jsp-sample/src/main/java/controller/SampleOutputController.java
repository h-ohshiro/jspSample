package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * input画面表示クラス
*/
@WebServlet("/output")
public class SampleOutputController extends HttpServlet {
	
	private static final Logger logger = LogManager.getLogger(SampleOutputController.class);
	final static String NONE_INPUT = "未入力";
	/**
	 * SampleInputControllerから受け取ったものをフォワードする
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException, IOException
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストのエンコーディングを指定
		
		// リクエストスコープからはObject型が返ってくるためキャスト
		final String name = (String) request.getAttribute("nameForOutput");
		final String email = (String) request.getAttribute("emailForOutput");
		final String opinion = (String) request.getAttribute("opinionForOutput");
		
		// 受け取ったものをログに出力してみる
		logger.info("名前：" + (name != "" ? name : NONE_INPUT));
		logger.info("メールアドレス：" + (email != "" ? email : NONE_INPUT));
		logger.info("意見：" + (opinion != "" ? opinion : NONE_INPUT));
		
		//画面に返す
		request.getRequestDispatcher("/input.jsp").forward(request, response);
	}
}
