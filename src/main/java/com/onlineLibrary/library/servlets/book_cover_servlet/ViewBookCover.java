package com.onlineLibrary.library.servlets.book_cover_servlet;

import com.onlineLibrary.library.service.LibraryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "ViewBookCover",
urlPatterns = {"/ViewBookCover"})
public class ViewBookCover extends HttpServlet {

    protected  void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String imageFormat = "image/jpeg";
        response.setContentType(imageFormat);

        try (OutputStream outputStream = response.getOutputStream()){
            int bookCoverId = Integer.valueOf(request.getParameter("bookCoverId"));
            LibraryService libraryService = (LibraryService) getServletContext().getAttribute("libraryService");
            byte[] bookCover = libraryService.getBooks().get(bookCoverId).getImage();
            response.setContentLength(bookCover.length);
            outputStream.write(bookCover);
        }catch (Exception ex){
            System.out.println("No load book cover.");
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
