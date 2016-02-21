package ru.artezio.dbWithView.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.artezio.dbWithView.models.TreeNode;

@Controller
@RequestMapping("/viewTree")
public class ViewTreeController {

    @RequestMapping(method = RequestMethod.GET)
    public String showTree(Model model) {
        String tree = TreeNode.createTree();
        model.addAttribute("tree", tree);
        return "ViewTree";
    }
}
