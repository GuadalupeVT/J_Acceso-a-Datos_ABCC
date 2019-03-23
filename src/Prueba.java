import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

class VentanaInicio extends JFrame implements ActionListener{
	
	JMenu menuPrincipalAlumnos;
	JMenuItem itemAltaAlumnos,itemBajaAlumnos,itemCambiosAlumnos,itemConsultasAlumnos;
	JInternalFrame internalFrameAltaAlumnos;
	JTextField altaCajaNumControl, altaCajaNombres, altaCajaApPaterno, altaCajaApMaterno;
	JComboBox altaComboSemestre, altaComboCarrera;
	JButton altaBtnAgregar, altaBtnBorrar, altaBtnCancelar;
	JTable altaTabla;
	DefaultTableModel altaModelo;
	
	public VentanaInicio() {
		getContentPane().setLayout(new BorderLayout());
		setSize(700, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		JMenuBar menuBar=new JMenuBar();
		menuPrincipalAlumnos= new JMenu("Alumnos");
		   
		    itemAltaAlumnos=new JMenuItem("Agregar");
		        itemAltaAlumnos.addActionListener(this);
		        itemAltaAlumnos.setMnemonic(KeyEvent.VK_G);
		        itemAltaAlumnos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.ALT_MASK));
		    menuPrincipalAlumnos.add(itemAltaAlumnos);
		   
		    itemBajaAlumnos=new JMenuItem("Eliminar");
		    menuPrincipalAlumnos.add(itemBajaAlumnos);
		    
		    itemCambiosAlumnos=new JMenuItem("Modificar");
		    menuPrincipalAlumnos.add(itemCambiosAlumnos);
		    
		    itemConsultasAlumnos=new JMenuItem("Buscar");
		    menuPrincipalAlumnos.add(itemConsultasAlumnos);
		
		menuBar.add(menuPrincipalAlumnos);
	        
	   
	    setJMenuBar(menuBar);
	   /* JToolBar toolBar=new JToolBar();
	       toolBar.add(new JButton("A"));
	       toolBar.add(new JButton("B"));
	       toolBar.add(new JButton("C"));
	       toolBar.add(new JButton("Co"));
	    add(toolBar,BorderLayout.PAGE_START);*/
		
		
	    //INTERNAL FRAMES ---------------------------------------
	    JDesktopPane desktopPane=new JDesktopPane();
	    
	    //-------------------------------------------------------------------------------
	    //Ventana altas alumnos
	     
	       internalFrameAltaAlumnos= new JInternalFrame("AGREGAR ALUMNO");
	       internalFrameAltaAlumnos.getContentPane().setLayout(null);
	       internalFrameAltaAlumnos.setDefaultCloseOperation(HIDE_ON_CLOSE);
	       internalFrameAltaAlumnos.setClosable(true);
	       internalFrameAltaAlumnos.setMaximizable(true);
	       internalFrameAltaAlumnos.setIconifiable(true);
	       internalFrameAltaAlumnos.setResizable(true);
	       internalFrameAltaAlumnos.setSize(630,500);
	       //internalFrameAltaAlumnos.setVisible(true);
	    
	       //componentes del internalFrameAltaAlumnos
	       JPanel panelAltaAlumnos=new JPanel();
	          panelAltaAlumnos.setBackground(new Color(58,228,53));
	          panelAltaAlumnos.setSize(630,70);
	          panelAltaAlumnos.setLayout(null);
	          
	          JLabel alta=new JLabel("<html> <p style=\"color:white;\">ALTAS ALUMNOS</p></html>");
	          alta.setBounds(20,0,300,70);
	          alta.setFont(new Font ("Segoe Script", 523, 25));
	          panelAltaAlumnos.add(alta); 
	       internalFrameAltaAlumnos.add(panelAltaAlumnos);
	       
	       
	          JLabel numControl=new JLabel("NUMERO DE CONTROL:");
	          numControl.setBounds(100, 100, 150, 50);
	          internalFrameAltaAlumnos.add(numControl);
	          
	          altaCajaNumControl=new JTextField();
	          altaCajaNumControl.setBounds(250,110,130,20);
	          internalFrameAltaAlumnos.add(altaCajaNumControl);
	          
	          JLabel nombres=new JLabel("NOMBRES:");
	          nombres.setBounds(100, 125, 150, 50);
	          internalFrameAltaAlumnos.add(nombres);
	          
	          altaCajaNombres=new JTextField();
	          altaCajaNombres.setBounds(180,140,200,20);
	          internalFrameAltaAlumnos.add(altaCajaNombres);
	          
	          JLabel apellidoP=new JLabel("APELLIDO PATERNO:");
	          apellidoP.setBounds(100, 155, 150, 50);
	          internalFrameAltaAlumnos.add(apellidoP);
	          
	          altaCajaApPaterno=new JTextField();
	          altaCajaApPaterno.setBounds(230,170,150,20);
	          internalFrameAltaAlumnos.add(altaCajaApPaterno);
	          
	          JLabel apellidoM=new JLabel("APELLIDO MATERNO:");
	          apellidoM.setBounds(100, 180, 150, 50);
	          internalFrameAltaAlumnos.add(apellidoM);
	          
	          altaCajaApMaterno=new JTextField();
	          altaCajaApMaterno.setBounds(230,195,150,20);
	          internalFrameAltaAlumnos.add(altaCajaApMaterno);
	          
	          JLabel semestre=new JLabel("SEMESTRE:");
	          semestre.setBounds(100, 210, 150, 50);
	          internalFrameAltaAlumnos.add(semestre);
	          
	          altaComboSemestre= new JComboBox();
	          altaComboSemestre.addItem("Elige Semestre...");
	          for(int i=1; i<=10; i++) {
	        	  altaComboSemestre.addItem(i);
	          }
	          altaComboSemestre.setBounds(230,225,150,20);
	          internalFrameAltaAlumnos.add(altaComboSemestre);
	          
	          JLabel carrera=new JLabel("CARRERA:");
	          carrera.setBounds(100, 240, 150, 50);
	          internalFrameAltaAlumnos.add(carrera);
	          
	          altaComboCarrera= new JComboBox();
	          altaComboCarrera.addItem("Elige Carrera:");
	        	  altaComboCarrera.addItem("ISC");
	        	  altaComboCarrera.addItem("IM");
	        	  altaComboCarrera.addItem("III");
	        	  altaComboCarrera.addItem("CP");
	        	  altaComboCarrera.addItem("LA");
	          altaComboCarrera.setBounds(230,255,150,20);
	          internalFrameAltaAlumnos.add(altaComboCarrera);
	          
	          altaBtnAgregar=new JButton("AGREGAR");
	          altaBtnAgregar.setBounds(400,120,100,25);
	          internalFrameAltaAlumnos.add(altaBtnAgregar);
	          
	          altaBtnBorrar=new JButton("BORRAR");
	          altaBtnBorrar.setBounds(400,180,100,25);
	          internalFrameAltaAlumnos.add(altaBtnBorrar);
	          
	          altaBtnCancelar=new JButton("CANCELAR");
	          altaBtnCancelar.setBounds(400,230,100,25);
	          internalFrameAltaAlumnos.add(altaBtnCancelar);
	         
	          JPanel panelTabla=new JPanel();
	          panelTabla.setSize(580,70);
	          panelTabla.setLayout(null);
	          panelTabla.setBounds(20,300,580,150);
	          
	          Object[][] data=new Object[0][0];
	          Object [] fila=new Object[6];
	          String[] datos = {"NO.DE CONTROL","NOMBRES","AP. PATERNO","AP.MATERNO","SEMESTRE","CARRERA"};
	          
	          altaModelo=new DefaultTableModel(data,datos);
	          altaTabla=new JTable(altaModelo);
	          altaTabla.setBounds(0,0,580,120);
	          altaModelo.addRow(new Object[]{"","","",""});
	          altaModelo.addRow(new Object[]{"","","",""});
	          altaModelo.addRow(new Object[]{"","","",""});
	          altaModelo.addRow(new Object[]{"","","",""});
	          altaModelo.addRow(new Object[]{"","","",""});
	          JScrollPane scroll=new JScrollPane(altaTabla);
	  		  scroll.setBounds(0,0,580,120);
	          panelTabla.add(scroll);
	          internalFrameAltaAlumnos.add(panelTabla);
	       desktopPane.add(internalFrameAltaAlumnos);
	       
	     //-------------------------------------------------------------------------------
		    //Ventana bajas alumnos
	       
	        
	       
	    desktopPane.setBackground(Color.BLACK);
	    add(desktopPane, BorderLayout.CENTER);
	    
	   
	    
	}//constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==itemAltaAlumnos) {
			internalFrameAltaAlumnos.setVisible(true);
		}
		
	}
	
	public void reestablecerComponentes(JComponent ...componentes) {
		for (JComponent c : componentes) {
			System.out.println(c.getClass());
			if(c instanceof JTextField)

			if (c instanceof JTextField)
				((JTextField)c).setText("");
			else if(c instanceof JComboBox) {
				((JComboBox)c).setSelectedIndex(0);
			}
		}
	}
	
}//class VentanaInicio
public class Prueba {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaInicio();
				
			}
		});

	}

}
