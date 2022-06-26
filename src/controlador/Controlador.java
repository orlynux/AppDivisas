/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.FrmInterfaz;

/**
 *
 * @author orlynux
 */
public class Controlador implements ActionListener {
    Modelo model;
    FrmInterfaz view;

    public Controlador(Modelo model, FrmInterfaz view) {
        this.model = model;
        this.view = view;
        view.cmdConvertir.addActionListener(this);
    }
    
    public void iniciar() {
        view.setTitle("Conversión de divisas");
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {  
        
        model.setDivisaEntrante(view.cboDe.getSelectedItem().toString());             
        switch (model.getDivisaEntrante()) {
           case "DLS":
            model.setDivisaSaliente(view.cboA.getSelectedItem().toString());
            switch (model.getDivisaSaliente()) {
                case "MXN":
                    model.setResultado(model.conversion(Double.valueOf(view.txtCantidad.getText()),model.DLS[0]));                   
                    break;
                case "EUR":
                    model.setResultado(model.conversion(Double.valueOf(view.txtCantidad.getText()),model.DLS[1]));                    
                    break;
                default:
                    model.setResultado(Double.valueOf(view.txtCantidad.getText()));                    
                    break;
            }
            break;
            
           case "EUR":
            model.setDivisaSaliente(view.cboA.getSelectedItem().toString());
            switch (model.getDivisaSaliente()) {
                case "MXN":                    
                    model.setResultado(model.conversion(Double.valueOf(view.txtCantidad.getText()),model.EUR[0]));
                    break;
                case "DLS":
                    model.setResultado(model.conversion(Double.valueOf(view.txtCantidad.getText()),model.EUR[1]));
                    break;
                default:
                    model.setResultado(Double.valueOf(view.txtCantidad.getText()));
                    break;
            }
            break;               
             
           case "MXN":
           model.setDivisaSaliente(view.cboA.getSelectedItem().toString());
            switch (model.getDivisaSaliente()) {
                case "DLS":
                    model.setResultado(model.conversion(Double.valueOf(view.txtCantidad.getText()),model.MXN[0]));
                    break;
                case "EUR":
                    model.setResultado (model.conversion(Double.valueOf(view.txtCantidad.getText()),model.MXN[1]));
                    break;
                default:
                    model.setResultado(Double.valueOf(view.txtCantidad.getText()));
                    break;
            }
               break;
       }
       view.lblResultado.setText(model.aMoneda(model.getResultado(),model.getDivisaSaliente()));
       view.txtCantidad.requestFocus();
       view.txtCantidad.selectAll();
    }
    
    
}
