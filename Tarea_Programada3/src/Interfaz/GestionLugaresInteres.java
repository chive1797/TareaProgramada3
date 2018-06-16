/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Estructuras.Arbol;
import Estructuras.BinarySearchTree;
import Estructuras.LinkedList;
import Estructuras.Raiz;
import Estructuras.TablaLugares;
import java.awt.Image;
import javax.swing.DefaultListModel;
import maps.java.Places;
import Estructuras.UbicacionActual;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import maps.java.StreetView;

/**
 *
 * @author Rolo
 */
public class GestionLugaresInteres extends javax.swing.JFrame {
    
    LinkedList lista = new LinkedList();
    private Places ObjPlaces=new Places();
    private UbicacionActual ubicacion=new UbicacionActual();
    private String[][] resultadoPlaces;
    private double fov=0.0;
    private DefaultListModel modeloLista = new DefaultListModel();

    /**
     * Creates new form GestionLugaresInteres
     */
    public GestionLugaresInteres() {
        initComponents();
        int contador=0;
        BinarySearchTree arbol = new BinarySearchTree();
        arbol.insert(contador);
    }
    private void buscarLocales() throws UnsupportedEncodingException, MalformedURLException, IOException{
        String keyword=LugarIntTxtField.getText();
//        resultadoPlaces=ObjPlaces.getPlaces(ObjUbicacion.getLatitud(), ObjUbicacion.getLongitud(), 
//                3000,keyword,null, this.buscarPor(),this.tiposLocal());
        resultadoPlaces=ObjPlaces.getPlaces(ubicacion.getLatitud(), ubicacion.getLongitud(),
                Integer.parseInt(RadioTxtField.getText()), keyword, null, Places.Rankby.distance, null);
        this.rellenarTabla(resultadoPlaces);
        String direcResultUNO=resultadoPlaces[0][2] + "," + resultadoPlaces[0][3];
        this.ImagenLugar(direcResultUNO);
    }

    private void rellenarTabla(String[][] datosPlaces) throws IOException{
        String[] columnas=new String[3];
        columnas[0]="Local";columnas[1]="Dirección";columnas[2]="Tipo establecimiento";
        Object[][] placesReducido=new Object[datosPlaces.length][3];
            for(int i=0; i<placesReducido.length;i++){
                placesReducido[i][0]=datosPlaces[i][0].toString();
                placesReducido[i][1]=datosPlaces[i][1].toString();
                Image imageCargada;
                imageCargada=ImageIO.read(new URL(datosPlaces[i][4]));
                imageCargada=imageCargada.getScaledInstance(20,20,Image.SCALE_FAST);
                placesReducido[i][2]=new ImageIcon(imageCargada);
            }
        TableModel tableModel=new TablaLugares(placesReducido, columnas);
        this.jTable_Places.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jTable_Places.setModel(tableModel);
        this.jTable_Places.setRowSelectionInterval(0, 0);
    }
    private void ImagenLugar(String direccion) throws MalformedURLException, UnsupportedEncodingException {
         StreetView ObjStreet=new StreetView();
         Image imagenStreet=ObjStreet.getStreetView(direccion, new Dimension(302,200),
                 fov, -1,-100);
         this.jLabel_StreetView.setIcon(new ImageIcon(imagenStreet));
    }
    private void detallesLugar() throws UnsupportedEncodingException{
        DetallesLugar detalles=new DetallesLugar(resultadoPlaces[jTable_Places.getSelectedRow()][5]);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        detalles.setLocation((d.width/2)-(detalles.getWidth()/2), (d.height/2)-(detalles.getHeight()/2));
        detalles.setVisible(true);
    }
    
    private void favoritosAgregar() throws UnsupportedEncodingException, MalformedURLException, IOException{
        String nombreLugar = (resultadoPlaces[jTable_Places.getSelectedRow()][0]);
        ConfirmarTxtField.setText(nombreLugar);
        
    }
        
    private void confirmarFavorito()throws UnsupportedEncodingException, MalformedURLException, IOException{
        String nombreLugar = (resultadoPlaces[jTable_Places.getSelectedRow()][0]);
        FileWriter writer = new FileWriter("Favoritos.txt", true);
        writer.write(nombreLugar);
        writer.write(System.getProperty("line.separator"));
        writer.close();
        
         
        

//            lista.insert(lugarConfirmado);
//            System.out.println(lista);
        
        
        
         
//         if (!lugarConfirmado.equals("confirmar")){  
//             ConfirmarTxtField.setText("confirmar");           
//             if (lugarConfirmado.equals("pare")){                
//                 System.out.println("SI");
//                 arbol.insert(nombreLugar);
//                 ConfirmarTxtField.setText("");
//             } 
//         }
//         System.out.println("\n"+raiz.getNombre()+"\n");
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LugarIntTxtField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Places = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        RadioTxtField = new javax.swing.JTextField();
        jLabel_StreetView = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ConfirmarTxtField = new javax.swing.JTextField();
        ConfirmarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setText("Lugar a buscar");

        jTable_Places.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Local", "Dirección", "Tipo establecimiento"
            }
        ));
        jTable_Places.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_PlacesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Places);

        jButton5.setText("Buscar lugares");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("Detalles del local");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Radio de búsqueda:");

        jButton1.setText("Agregar a favoritos");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        ConfirmarBtn.setText("Confirmar");
        ConfirmarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmarBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RadioTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                        .addComponent(LugarIntTxtField, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel_StreetView, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ConfirmarBtn)
                            .addComponent(ConfirmarTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(LugarIntTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(RadioTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_StreetView, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ConfirmarTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ConfirmarBtn)
                        .addGap(13, 13, 13))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_PlacesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_PlacesMouseClicked
        try {
            String direccionSeleccionado=resultadoPlaces[jTable_Places.getSelectedRow()][2] +
            "," + resultadoPlaces[jTable_Places.getSelectedRow()][3];
            this.ImagenLugar(direccionSeleccionado);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jTable_PlacesMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            this.buscarLocales();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            detallesLugar();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try{
            favoritosAgregar();
        }catch (Exception e){
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void ConfirmarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmarBtnMouseClicked
        BinarySearchTree arbol = new BinarySearchTree();
        Raiz raiz = new Raiz();        
        if(raiz.getNombre()==null){
            raiz.setNombre(ubicacion.getDireccion());
            arbol.insert(raiz.getNombre());
        }
        try{
            if(!ConfirmarTxtField.getText().equals("Confirmado")){
                lista.insert(ConfirmarTxtField.getText());
                System.out.println(lista);
            }else{
                System.out.println(lista);
                while(lista.getSize() != 0){
                arbol.insert(lista.getElementValue(lista.getSize()-lista.getSize()).toString());
                lista.EliminarElemento(lista.getSize()-lista.getSize());            
                }
                System.out.print("Lo siguiente es el arbol"+"\n");
                arbol.printPreorder();
            }           
            confirmarFavorito();    
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_ConfirmarBtnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionLugaresInteres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionLugaresInteres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionLugaresInteres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionLugaresInteres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionLugaresInteres().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmarBtn;
    private javax.swing.JTextField ConfirmarTxtField;
    private javax.swing.JTextField LugarIntTxtField;
    private javax.swing.JTextField RadioTxtField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_StreetView;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Places;
    // End of variables declaration//GEN-END:variables
}
