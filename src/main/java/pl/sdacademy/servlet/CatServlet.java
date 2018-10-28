package pl.sdacademy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static pl.sdacademy.servlet.CatParams.*;

public class CatServlet extends HttpServlet {

    private CatRepository catRepository;

    public CatServlet(CatRepository catRepository) {
        this.catRepository = catRepository;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        catRepository.save(new Cat(req.getParameter(RACE), req.getParameter(NAME), req.getParameter(OWNER)));
        resp.sendRedirect("/cats");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cat> cats = new ArrayList<>();
        String filterWord = req.getParameter("searchParam");
        String option = req.getParameter("option");
        if (filterWord != null && !filterWord.isEmpty()) {
            switch (option) {
                case "race":
                    cats = catRepository.findByRace(filterWord);
                    break;
                case "name":
                    cats = catRepository.findByName(filterWord);
                    break;
                case "owner":
                    cats = catRepository.findByOwner(filterWord);
                    break;
            }

        } else {
            cats = catRepository.findAll();
        }
        req.setAttribute(CatModelAttr.ALL_CATS, cats);
        req.getRequestDispatcher("/form.jsp").forward(req, resp);
    }
}
