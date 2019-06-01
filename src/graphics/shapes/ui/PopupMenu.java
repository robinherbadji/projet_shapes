package graphics.shapes.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class PopupMenu {

    JPopupMenu menu = new JPopupMenu();

    private ShapesController c;

    public PopupMenu(ShapesController c) {
        this.c = c;
    }

    //Menu clic droit 
    public JPopupMenu pop(MouseEvent e) {

        JMenu edit = new JMenu("Edit");
   
        //Delete Action by RightmouseClick
        JMenuItem del = new JMenuItem("Delete");
        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                c.delete();
            }
        });
        edit.add(del);
        
        //Resize Action by RightmouseClick
        JMenuItem res = new JMenuItem("Resize");
        res.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                c.resize();
            }
        });
        edit.add(res);

        //ChangeText Action by RightmouseClick
        JMenuItem tex = new JMenuItem("Change Text");
        tex.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                c.changeText();
            }
        });
        edit.add(tex);

        edit.addSeparator(); //Separator between the Items

        //Copy Action by RightmouseClick
        JMenuItem cop = new JMenuItem("Copy");
        cop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                c.split();
            }
        });
        edit.add(cop);

        // Paste Action by RightmouseClick
        JMenuItem pas = new JMenuItem("Paste");
        pas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                c.join();
            }
        });
        edit.add(pas);

        edit.addSeparator();
        
        JMenuItem joi = new JMenuItem("Join");
        joi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                c.join();
            }
        });
        edit.add(joi);

        menu.add(edit);
        
        this.menu.show(e.getComponent(), e.getX(), e.getY());
        return this.menu;
   }

}
