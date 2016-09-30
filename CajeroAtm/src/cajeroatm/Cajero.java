
//Clase
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroatm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Alumno
 */
public class Cajero extends JFrame {

    float resultado;
    JTextField pantalla;
    JPanel pNumeros, pOperacion;
    int operacion;
    String nombre = "";
    JPanel panel = (JPanel) this.getContentPane();
    public Cajero() {
        super();
        setTitle("Cajero");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

       // JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new BorderLayout());

        pantalla = new JTextField("", 20);
        pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
        pantalla.setFont(new Font("Arial", Font.BOLD, 25));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setBackground(Color.LIGHT_GRAY);
        //pantalla.disable();
        panel.add("North", pantalla);

        pOperacion = new JPanel();
        pOperacion.setLayout(new GridLayout(6, 1));
        pOperacion.setBorder(new EmptyBorder(4, 4, 4, 4));

        panel.add("East", pOperacion);
        
        pNumeros = new JPanel();
        pNumeros.setLayout(new GridLayout(6,4));
        pNumeros.setBorder(new EmptyBorder(4,4,4,4));
        pNumeros.setVisible(false);
        panel.add("South",pNumeros);
        
        botonNumeros("5");
        botonNumeros("10");
        botonNumeros("15");
        botonNumeros("20");
        botonNumeros("Cancelar");


        botonOperacion("Cuenta");
        botonOperacion("Ver saldo");
        botonOperacion("Depositar");
        botonOperacion("Retirar");
        botonOperacion("Ingresar");
        botonOperacion("Le gustaria donar");
        botonOperacion("Salir");

        validate();
    }
    
    public void botonNumeros(String numero){
        JButton btn = new JButton(numero);
        btn.setForeground(Color.DARK_GRAY);
        
        btn.addMouseListener(new MouseAdapter() {

        public void mouseReleased(MouseEvent evt){
            JButton btn = (JButton) evt.getSource();
            Donacion(btn.getText());
        }
        
        });
        
        pNumeros.add(btn);
    }

    public void botonOperacion(String operacion) {

        JButton btn = new JButton(operacion);
        btn.setForeground(Color.DARK_GRAY);

        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                //deposito(btn.getText());
                //retiro(btn.getText());
                login(btn.getText());
                //saldo(btn.getText());

            }

        });

        pOperacion.add(btn);
    }

    public void login(String tecla) {
       
                            if(tecla.equals("Ver saldo"))
                {   
                    if(nombre.equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Registrate con tu nombre");
                    }
                    else
                    {
                        pantalla.setText(""+resultado);
                    }
                }
                else
		if(tecla.equals("Cuenta")) 
                {
                    
                        JOptionPane.showMessageDialog(null, "Por favor al termnio de cada operacion oprima el boton ingresar");
                        pantalla.setEditable(true);
                        JOptionPane.showMessageDialog(null, "Ingrese su nombre por favor");
                        pantalla.requestFocus();
                        operacion = 1;
                  
                 
                }
                else
                if (tecla.equals("Depositar"))
                {
                    if(nombre.equals(""))
                    {
                       JOptionPane.showMessageDialog(null,"Registrate con tu nombre");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Ingrese su deposito");
                        pantalla.setEditable(true);  
                        pantalla.requestFocus();
                        pantalla.setText("");
                        operacion = 2;
                        
            
                }
                }
                else
                if (tecla.equals("Retirar"))
                {
                   if(nombre.equals(""))
                    {
                      JOptionPane.showMessageDialog(null,"Registrate con tu nombre");
                    }
                    else
                    {
                                   JOptionPane.showMessageDialog(null, "Ingrese su Retiro");
                        pantalla.setEditable(true);
                        pantalla.setText("");
                        pantalla.requestFocus();
                            operacion = 3;
                            
                    }
                } else if(tecla.equals("Ingresar")){
                    if(operacion == 1){
                        nombre = pantalla.getText();
                        JOptionPane.showMessageDialog(null, "hola "+nombre);
                        setTitle("Sr@ "+nombre);
                    }else
                        if(operacion == 2){
                     
                           
                              int j = JOptionPane.showConfirmDialog(null, "Esta seguro de realizar el deposito?", "Aviso", WIDTH);

                                if (j >= 1) {
                                    JOptionPane.showMessageDialog(null, "deposito Cancelado");
                                    pantalla.setText("");
                                } else {

                                    resultado += new Float(pantalla.getText());
                                    JOptionPane.showMessageDialog(null, "deposito realizado con exito");
                                    pantalla.setText("");
                                }
                    
                        }else
                            if(operacion == 3)
                            {
                                
                                 int j = JOptionPane.showConfirmDialog(null, "Esta seguro de realizar el Retiro?", "Aviso", WIDTH);

                                if (j >= 1) {
                                    JOptionPane.showMessageDialog(null, "Retiro Cancelado");
                                    pantalla.setText("");
                                } else {

                                    resultado -= new Float(pantalla.getText());
                                    JOptionPane.showMessageDialog(null, "Retiro realizado con exito");
                                    pantalla.setText("");
                                }   
                            }
                    
                } else if(tecla.equals("Salir")){
                    JOptionPane.showMessageDialog(null, "hasta pronto "+nombre);
                    nombre = "";
                    pantalla.setText("");
                    setTitle("Cajero");
                    
                } else if(tecla.equals("Le gustaria donar")){
                    if(nombre.equals("")){
                        JOptionPane.showMessageDialog(null, "Ingrese con su nombre");
                    } else {
                    
                  //  Donacion D = new Donacion();
                    pNumeros.setVisible(true);
                    }
                }
    }
    public void Donacion (String tecla){
         
                    if(tecla.equals("5")){
                        resultado -= 5;
                        JOptionPane.showMessageDialog(null, "Gracias por su donacion"); 
                    } else if(tecla.equals("10")){
                        
                        resultado -= 10;
                        JOptionPane.showMessageDialog(null, "Gracias por su donacion"); 
                    } else if(tecla.equals("15")){
                        
                        resultado -= 15;
                        JOptionPane.showMessageDialog(null, "Gracias por su donacion"); 
                    }else if(tecla.equals("20")){
                        resultado -= 20;
                        JOptionPane.showMessageDialog(null, "Gracias por su donacion"); 
                    } else if(tecla.equals("Cancelar")){
                        pNumeros.setVisible(false);
                    }
                    
                }
    
}
   


