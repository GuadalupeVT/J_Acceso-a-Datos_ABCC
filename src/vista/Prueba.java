package vista;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controlador.AlumnoDAO;
import modelo.Alumno;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

class VentanaInicio extends JFrame implements ActionListener, KeyListener{
	boolean enter;
	JMenu menuPrincipalAlumnos;
	JMenuItem itemAltaAlumnos,itemBajaAlumnos,itemCambiosAlumnos,itemConsultasAlumnos;
	JInternalFrame internalFrameAltaAlumnos, internalFrameBajasAlumnos, internalFrameModificarAlumnos, internalFrameConsultasAlumnos;
	JTextField altaCajaNumControl, altaCajaNombres, altaCajaApPaterno, altaCajaApMaterno;
	JTextField bajasCajaNumControl, bajasCajaNombres, bajasCajaApPaterno, bajasCajaApMaterno;
	JTextField modificarCajaNumControl, modificarCajaNombres, modificarCajaApPaterno, modificarCajaApMaterno;
	JTextField  consultaCajaNombres, consultaCajaApPaterno, consultaCajaApMaterno;
	JComboBox altaComboSemestre, altaComboCarrera, bajaComboCarrera,modificarComboCarrera, consultaComboCarrera;
	JButton altaBtnAgregar, altaBtnBorrar, altaBtnCancelar;
	JButton bajaBtnBuscar, bajaBtnBorrar, bajaBtnEliminar, bajaBtnCancelar;
	JButton modificarBtnBuscar, modificarBtnBorrar, modificarBtnGuardar, modificarBtnCancelar;
	JButton consultarBtnBuscar, consultarBtnBorrar, consultarBtnCancelar;
	JSpinner bajasSpinnerSemestre, modificarSpinnerSemestre, consultaSpinnerSemestre;
	JTable altaTabla, bajaTabla, modificarTabla, consultaTabla;
	DefaultTableModel altaModelo, bajaModelo, modificarModelo, consultaModelo;
	JRadioButton radioTodos,radioNombre,radioApPaterno,radioApMaterno,radioSemestre,radioCarrera;
	ButtonGroup bg;
	
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
		       itemBajaAlumnos.addActionListener(this);
	           itemBajaAlumnos.setMnemonic(KeyEvent.VK_E);
	           itemBajaAlumnos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
		    menuPrincipalAlumnos.add(itemBajaAlumnos);
		    
		    itemCambiosAlumnos=new JMenuItem("Modificar");
		       itemCambiosAlumnos.addActionListener(this);
	           itemCambiosAlumnos.setMnemonic(KeyEvent.VK_M);
	           itemCambiosAlumnos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));
		    menuPrincipalAlumnos.add(itemCambiosAlumnos);
		    
		    itemConsultasAlumnos=new JMenuItem("Buscar");
		       itemConsultasAlumnos.addActionListener(this);
	           itemConsultasAlumnos.setMnemonic(KeyEvent.VK_B);
	           itemConsultasAlumnos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
		    menuPrincipalAlumnos.add(itemConsultasAlumnos);
		
		menuBar.add(menuPrincipalAlumnos);
	        
	   
	    setJMenuBar(menuBar);
	    //INTERNAL FRAMES ---------------------------------------
	    JDesktopPane desktopPane=new JDesktopPane();
	    
	    //-------------------------------------------------------------------------------
	    //Ventana altas alumnos
	     
	       internalFrameAltaAlumnos= new JInternalFrame("AGREGAR ALUMNO");
	       internalFrameAltaAlumnos.getContentPane().setLayout(null);
	       internalFrameAltaAlumnos.setDefaultCloseOperation(HIDE_ON_CLOSE);
	       internalFrameAltaAlumnos.setClosable(true);
	       internalFrameAltaAlumnos.setIconifiable(true);
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
	          altaComboCarrera.addKeyListener(this);
	          internalFrameAltaAlumnos.add(altaComboCarrera);
	          
	          altaBtnAgregar=new JButton("AGREGAR");
	          altaBtnAgregar.setBounds(400,120,100,25);
	          altaBtnAgregar.addActionListener(this);
	          altaBtnAgregar.addKeyListener(this);
	          internalFrameAltaAlumnos.add(altaBtnAgregar);
	          
	          altaBtnBorrar=new JButton("BORRAR");
	          altaBtnBorrar.setBounds(400,180,100,25);
	          altaBtnBorrar.addActionListener(this);
	          internalFrameAltaAlumnos.add(altaBtnBorrar);
	          
	          altaBtnCancelar=new JButton("CANCELAR");
	          altaBtnCancelar.setBounds(400,230,100,25);
	          altaBtnCancelar.addActionListener(this);
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
	       
	       
	       internalFrameBajasAlumnos= new JInternalFrame("Eliminar Alumno");
	       internalFrameBajasAlumnos.getContentPane().setLayout(null);
	       internalFrameBajasAlumnos.setDefaultCloseOperation(HIDE_ON_CLOSE);
	       internalFrameBajasAlumnos.setClosable(true);
	       internalFrameBajasAlumnos.setMaximizable(true);
	       internalFrameBajasAlumnos.setIconifiable(true);
	       internalFrameBajasAlumnos.setResizable(true);
	       internalFrameBajasAlumnos.setSize(630,500);
	      
	       //componentes del internalFrameAltaAlumnos
	       JPanel panelBajasAlumnos=new JPanel();
	          panelBajasAlumnos.setBackground(Color.RED);
	          panelBajasAlumnos.setSize(630,60);
	          panelBajasAlumnos.setLayout(null);
	          
	          JLabel baja=new JLabel("<html> <p style=\"color:white;\">BAJAS ALUMNOS</p></html>");
	          baja.setBounds(20,0,300,60);
	          baja.setFont(new Font ("Segoe Script", 523, 25));
	          panelBajasAlumnos.add(baja); 
	          internalFrameBajasAlumnos.add(panelBajasAlumnos);
	       
	      
	          JLabel bajasNumControl=new JLabel("NUMERO DE CONTROL:");
	          bajasNumControl.setBounds(60,70,140,30);
	          internalFrameBajasAlumnos.add(bajasNumControl);
	          
	          bajasCajaNumControl=new JTextField();
	          bajasCajaNumControl.setBounds(200,70,80,30);
	          internalFrameBajasAlumnos.add(bajasCajaNumControl);
	          
	          bajaBtnBuscar=new JButton();
	          bajaBtnBuscar.setBounds(320, 70, 100, 40);

	          bajaBtnBuscar.setIcon(new ImageIcon("./src/iconoDeBusqueda.png"));
	          bajaBtnBuscar.addActionListener(this);
	          internalFrameBajasAlumnos.add(bajaBtnBuscar);
	          
	          bajaBtnBorrar = new JButton("BORRAR");
	          bajaBtnBorrar.setBounds(450, 75, 100, 25);
	          internalFrameBajasAlumnos.add(bajaBtnBorrar);
	          
	          JLabel bajaNombres = new JLabel("NOMBRE(S):");
	          bajaNombres.setBounds(60,130,80,30);
	          internalFrameBajasAlumnos.add(bajaNombres);
	          
	          bajasCajaNombres=new JTextField();
	          bajasCajaNombres.setBounds(210,130,150,30);
	          bajasCajaNombres.setEnabled(false);
	          internalFrameBajasAlumnos.add(bajasCajaNombres);
	          
	          JLabel apPaterno=new JLabel("APELLIDO PATERNO:");
	          apPaterno.setBounds(60,170,120,30);
	          internalFrameBajasAlumnos.add(apPaterno);
	          
	          bajasCajaApPaterno=new JTextField();
	          bajasCajaApPaterno.setBounds(210,170,150,30);
	          bajasCajaApPaterno.setEnabled(false);
	          internalFrameBajasAlumnos.add(bajasCajaApPaterno);
	          
	          JLabel apMaterno=new JLabel("APELLIDO MATERNO:");
	          apMaterno.setBounds(60,210,120,30);
	          internalFrameBajasAlumnos.add(apMaterno);
	          
	          bajasCajaApMaterno=new JTextField();
	          bajasCajaApMaterno.setBounds(210,210,150,30);
	          bajasCajaApMaterno.setEnabled(false);
	          internalFrameBajasAlumnos.add(bajasCajaApMaterno);
	          
	          JLabel bajasSemestre=new JLabel("SEMESTRE:");
	          bajasSemestre.setBounds(60,250,120,30);
	          internalFrameBajasAlumnos.add(bajasSemestre);
	          
	          bajasSpinnerSemestre=new JSpinner();
	          bajasSpinnerSemestre.setBounds(210,250,150,30);
	          bajasSpinnerSemestre.setEnabled(false);
	          internalFrameBajasAlumnos.add(bajasSpinnerSemestre);
	          
	          JLabel bajasCarrera=new JLabel("CARRERA:");
	          bajasCarrera.setBounds(60,290,120,30);
	          internalFrameBajasAlumnos.add(bajasCarrera);
	          
	          bajaComboCarrera= new JComboBox();
	        	  bajaComboCarrera.addItem("ISC");
	        	  bajaComboCarrera.addItem("IM");
	        	  bajaComboCarrera.addItem("III");
	        	  bajaComboCarrera.addItem("CP");
	        	  bajaComboCarrera.addItem("LA");
	          bajaComboCarrera.setBounds(210,290,150,30);
	          bajaComboCarrera.setEnabled(false);
	          internalFrameBajasAlumnos.add(bajaComboCarrera);
	          
	          bajaBtnEliminar=new JButton("ELIMINAR");
	          bajaBtnEliminar.setBounds(450, 175, 100, 25);
	          internalFrameBajasAlumnos.add(bajaBtnEliminar);
	          
	          bajaBtnCancelar=new JButton("CANCELAR");
	          bajaBtnCancelar.setBounds(450, 240, 100, 25);
	          internalFrameBajasAlumnos.add(bajaBtnCancelar);
	          
	          JPanel panelTabla1=new JPanel();
	          panelTabla1.setSize(580,70);
	          panelTabla1.setLayout(null);
	          panelTabla1.setBounds(20,330,580,150);
 
	          Object[][] data1=new Object[0][0];
	          Object [] fila1=new Object[6];
	          String[] datos1 = {"NO.DE CONTROL","NOMBRES","AP. PATERNO","AP.MATERNO","SEMESTRE","CARRERA"};
	          
	          bajaModelo=new DefaultTableModel(data1,datos1);
	          bajaTabla=new JTable(bajaModelo);
	          bajaTabla.setBounds(0,0,580,120);
	          bajaModelo.addRow(new Object[]{"","","",""});
	          bajaModelo.addRow(new Object[]{"","","",""});
	          bajaModelo.addRow(new Object[]{"","","",""});
	          bajaModelo.addRow(new Object[]{"","","",""});
	          bajaModelo.addRow(new Object[]{"","","",""});
	          JScrollPane scroll1=new JScrollPane(bajaTabla);
	  		  scroll1.setBounds(0,0,580,120);
	          panelTabla1.add(scroll1);
	          internalFrameBajasAlumnos.add(panelTabla1);
	       desktopPane.add(internalFrameBajasAlumnos);
	       
	       
	     //-------------------------------------------------------------------------------
		    //Ventana Modificaciones alumno
	       internalFrameModificarAlumnos= new JInternalFrame("Modificar Alumno");
	       internalFrameModificarAlumnos.getContentPane().setLayout(null);
	       internalFrameModificarAlumnos.setDefaultCloseOperation(HIDE_ON_CLOSE);
	       internalFrameModificarAlumnos.setClosable(true);
	       internalFrameModificarAlumnos.setMaximizable(true);
	       internalFrameModificarAlumnos.setIconifiable(true);
	       internalFrameModificarAlumnos.setResizable(true);
	       internalFrameModificarAlumnos.setSize(630,500);
	       //internalFrameAltaAlumnos.setVisible(true);
	    
	       //componentes del internalFrameAltaAlumnos
	       JPanel panelModificarAlumnos=new JPanel();
	          panelModificarAlumnos.setBackground(new Color(255,128,0));
	          panelModificarAlumnos.setSize(630,60);
	          panelModificarAlumnos.setLayout(null);
	          
	          JLabel modificar=new JLabel("<html> <p style=\"color:white;\">MODIFICACIONES ALUMNOS</p></html>");
	          modificar.setBounds(20,0,400,60);
	          modificar.setFont(new Font ("Segoe Script", 523, 23));
	          panelModificarAlumnos.add(modificar); 
	          internalFrameModificarAlumnos.add(panelModificarAlumnos);
	       
	      
	          JLabel modificarNumControl=new JLabel("NUMERO DE CONTROL:");
	          modificarNumControl.setBounds(60,70,140,30);
	          internalFrameModificarAlumnos.add(modificarNumControl);
	          
	          modificarCajaNumControl=new JTextField();
	          modificarCajaNumControl.setBounds(200,70,80,30);
	          internalFrameModificarAlumnos.add(modificarCajaNumControl);
	          
	          modificarBtnBuscar=new JButton();
	          modificarBtnBuscar.setBounds(320, 70, 100, 40);
	          modificarBtnBuscar.setIcon(new ImageIcon("./src/iconoDeBusqueda.png"));
	          internalFrameModificarAlumnos.add(modificarBtnBuscar);
	          
	          modificarBtnBorrar = new JButton("BORRAR");
	          modificarBtnBorrar.setBounds(450, 75, 100, 25);
	          internalFrameModificarAlumnos.add(modificarBtnBorrar);
	          
	          JLabel modificarNombres = new JLabel("NOMBRE(S):");
	          modificarNombres.setBounds(60,130,80,30);
	          internalFrameModificarAlumnos.add(modificarNombres);
	          
	          modificarCajaNombres=new JTextField();
	          modificarCajaNombres.setBounds(210,130,150,30);
	          //bajasCajaNombres.setEditable(false);
	          internalFrameModificarAlumnos.add(modificarCajaNombres);
	          
	          JLabel mApPaterno=new JLabel("APELLIDO PATERNO:");
	          mApPaterno.setBounds(60,170,120,30);
	          internalFrameModificarAlumnos.add(mApPaterno);
	          
	          modificarCajaApPaterno=new JTextField();
	          modificarCajaApPaterno.setBounds(210,170,150,30);
	          internalFrameModificarAlumnos.add(modificarCajaApPaterno);
	          
	          JLabel mApMaterno=new JLabel("APELLIDO MATERNO:");
	          mApMaterno.setBounds(60,210,120,30);
	          internalFrameModificarAlumnos.add(mApMaterno);
	          
	          modificarCajaApMaterno=new JTextField();
	          modificarCajaApMaterno.setBounds(210,210,150,30);
	          internalFrameModificarAlumnos.add(modificarCajaApMaterno);
	          
	          JLabel modificarSemestre=new JLabel("SEMESTRE:");
	          modificarSemestre.setBounds(60,250,120,30);
	          internalFrameModificarAlumnos.add(modificarSemestre);
	          
	          modificarSpinnerSemestre=new JSpinner();
	          modificarSpinnerSemestre.setBounds(210,250,150,30);
	          internalFrameModificarAlumnos.add(modificarSpinnerSemestre);
	          
	          JLabel modificarCarrera=new JLabel("CARRERA:");
	          modificarCarrera.setBounds(60,290,120,30);
	          internalFrameModificarAlumnos.add(modificarCarrera);
	          
	          modificarComboCarrera= new JComboBox();
	          modificarComboCarrera.addItem("ISC");
	          modificarComboCarrera.addItem("IM");
	          modificarComboCarrera.addItem("III");
	          modificarComboCarrera.addItem("CP");
	          modificarComboCarrera.addItem("LA");
	          modificarComboCarrera.setBounds(210,290,150,30);
	          internalFrameModificarAlumnos.add(modificarComboCarrera);
	          
	          modificarBtnGuardar=new JButton("GUARDAR CAMBIOS");
	          modificarBtnGuardar.setBounds(450, 175, 150, 25);
	          internalFrameModificarAlumnos.add(modificarBtnGuardar);
	          
	          modificarBtnCancelar=new JButton("CANCELAR");
	          modificarBtnCancelar.setBounds(450, 240, 150, 25);
	          internalFrameModificarAlumnos.add(modificarBtnCancelar);
	          
	          JPanel panelTabla2=new JPanel();
	          panelTabla2.setSize(580,70);
	          panelTabla2.setLayout(null);
	          panelTabla2.setBounds(20,330,580,150);
 
	          Object[][] data2=new Object[0][0];
	          Object [] fila2=new Object[6];
	          String[] datos2= {"NO.DE CONTROL","NOMBRES","AP. PATERNO","AP.MATERNO","SEMESTRE","CARRERA"};
	          
	          modificarModelo=new DefaultTableModel(data1,datos1);
	          modificarTabla=new JTable(modificarModelo);
	          modificarTabla.setBounds(0,0,580,120);
	          modificarModelo.addRow(new Object[]{"","","",""});
	          modificarModelo.addRow(new Object[]{"","","",""});
	          modificarModelo.addRow(new Object[]{"","","",""});
	          modificarModelo.addRow(new Object[]{"","","",""});
	          modificarModelo.addRow(new Object[]{"","","",""});
	          JScrollPane scroll2=new JScrollPane(modificarTabla);
	  		  scroll2.setBounds(0,0,580,120);
	          panelTabla2.add(scroll2);
	          internalFrameModificarAlumnos.add(panelTabla2);
	       desktopPane.add(internalFrameModificarAlumnos);
	       
	       //-----------------------------------------------------------
	     //Ventana Consultas alumno
	       internalFrameConsultasAlumnos= new JInternalFrame("Buscar Alumno");
	       internalFrameConsultasAlumnos.getContentPane().setLayout(null);
	       internalFrameConsultasAlumnos.setDefaultCloseOperation(HIDE_ON_CLOSE);
	       internalFrameConsultasAlumnos.setClosable(true);
	       internalFrameConsultasAlumnos.setMaximizable(true);
	       internalFrameConsultasAlumnos.setIconifiable(true);
	       internalFrameConsultasAlumnos.setResizable(true);
	       internalFrameConsultasAlumnos.setSize(630,500);
	       
	       JPanel panelConsultasAlumnos=new JPanel();
	          panelConsultasAlumnos.setBackground(Color.BLUE);
	          panelConsultasAlumnos.setSize(630,60);
	          panelConsultasAlumnos.setLayout(null);
	          
	          JLabel consultas=new JLabel("<html> <p style=\"color:white;\">CONSULTAS ALUMNOS</p></html>");
	          consultas.setBounds(20,0,400,60);
	          consultas.setFont(new Font ("Segoe Script", 523, 23));
	          panelConsultasAlumnos.add(consultas); 
	          internalFrameConsultasAlumnos.add(panelConsultasAlumnos);
	          
	          JLabel criterio=new JLabel("Selecciona criterio de busqueda:");
	          criterio.setBounds(20,70,200,30);
	          internalFrameConsultasAlumnos.add(criterio);
	       
	          bg= new ButtonGroup();
	          radioTodos=new JRadioButton("TODOS");
	  		  bg.add(radioTodos);
	  		  radioTodos.setBounds(20,110,80,30);
	  		  radioTodos.addActionListener(this);
	  		  internalFrameConsultasAlumnos.add(radioTodos);
	  		  
	  		  radioNombre=new JRadioButton("NOMBRE");
	  		  bg.add(radioNombre);
	  		  radioNombre.setBounds(120,110,80,30);
	  		  radioNombre.addActionListener(this);
	  		  internalFrameConsultasAlumnos.add(radioNombre);
	  		  
	  		  radioApPaterno=new JRadioButton("APELLIDO PATERNO");
	  		  bg.add(radioApPaterno);
	  		  radioApPaterno.setBounds(120,150,150,30);
	  		  radioApPaterno.addActionListener(this);
	  		  internalFrameConsultasAlumnos.add(radioApPaterno);
	  		  
	  		  radioApMaterno=new JRadioButton("APELLIDO MATERNO");
	  		  bg.add(radioApMaterno);
	  		  radioApMaterno.setBounds(120,190,150,30);
	  		  radioApMaterno.addActionListener(this);
	  		  internalFrameConsultasAlumnos.add(radioApMaterno);
	       
	  		  radioSemestre=new JRadioButton("SEMESTRE");
	  		  bg.add(radioSemestre);
	  		  radioSemestre.setBounds(120,230,100,30);
	  		  radioSemestre.addActionListener(this);
	  		  internalFrameConsultasAlumnos.add(radioSemestre);
	  		  
	  		  radioCarrera=new JRadioButton("CARRERA");
	  		  bg.add(radioCarrera);
	  		  radioCarrera.setBounds(120,270,100,30);
	  		  radioCarrera.addActionListener(this);
	  		  internalFrameConsultasAlumnos.add(radioCarrera);
	  		  
	  		  consultaCajaNombres=new JTextField();
	          consultaCajaNombres.setBounds(280,110,150,30);
	          consultaCajaNombres.setEnabled(false);
	          internalFrameConsultasAlumnos.add(consultaCajaNombres);
	          
	          consultaCajaApPaterno=new JTextField();
	          consultaCajaApPaterno.setBounds(280,150,150,30);
	          consultaCajaApPaterno.setEnabled(false);
	          internalFrameConsultasAlumnos.add(consultaCajaApPaterno);
	          
	          consultaCajaApMaterno=new JTextField();
	          consultaCajaApMaterno.setBounds(280,190,150,30);
	          consultaCajaApMaterno.setEnabled(false);
	          internalFrameConsultasAlumnos.add(consultaCajaApMaterno);
	          
	          consultaSpinnerSemestre=new JSpinner();
	          consultaSpinnerSemestre.setBounds(280,230,150,30);
	          consultaSpinnerSemestre.setEnabled(false);
	          internalFrameConsultasAlumnos.add(consultaSpinnerSemestre);
	       
	          consultaComboCarrera= new JComboBox();
	          consultaComboCarrera.addItem("ISC");
	          consultaComboCarrera.addItem("IM");
	          consultaComboCarrera.addItem("III");
	          consultaComboCarrera.addItem("CP");
	          consultaComboCarrera.addItem("LA");
	          consultaComboCarrera.setBounds(280,270,150,30);
	          consultaComboCarrera.setEnabled(false);
	          internalFrameConsultasAlumnos.add(consultaComboCarrera);
	       
	          consultarBtnBuscar=new JButton();
	          consultarBtnBuscar.setBounds(480, 125, 100, 40);
	          consultarBtnBuscar.setIcon(new ImageIcon("./src/iconoDeBusqueda.png"));
	          internalFrameConsultasAlumnos.add(consultarBtnBuscar);
	          
	          consultarBtnBorrar=new JButton("BORRAR");
	          consultarBtnBorrar.setBounds(480, 190, 100, 25);
	          internalFrameConsultasAlumnos.add(consultarBtnBorrar);
	          
	          consultarBtnCancelar=new JButton("CANCELAR");
	          consultarBtnCancelar.setBounds(480, 240, 100, 25);
	          internalFrameConsultasAlumnos.add(consultarBtnCancelar);
	          
	          JPanel panelTabla3=new JPanel();
	          panelTabla3.setSize(580,70);
	          panelTabla3.setLayout(null);
	          panelTabla3.setBounds(20,330,580,150);
 
	          Object[][] data3=new Object[0][0];
	          Object [] fila3=new Object[6];
	          String[] datos3= {"NO.DE CONTROL","NOMBRES","AP. PATERNO","AP.MATERNO","SEMESTRE","CARRERA"};
	          
	          consultaModelo=new DefaultTableModel(data1,datos1);
	          consultaTabla=new JTable(consultaModelo);
	          modificarTabla.setBounds(0,0,580,120);
	          consultaModelo.addRow(new Object[]{"","","",""});
	          consultaModelo.addRow(new Object[]{"","","",""});
	          consultaModelo.addRow(new Object[]{"","","",""});
	          consultaModelo.addRow(new Object[]{"","","",""});
	          consultaModelo.addRow(new Object[]{"","","",""});
	          JScrollPane scroll3=new JScrollPane(consultaTabla);
	  		  scroll3.setBounds(0,0,580,120);
	          panelTabla3.add(scroll3);
	          internalFrameConsultasAlumnos.add(panelTabla3);
	          
	          
	       desktopPane.add(internalFrameConsultasAlumnos);

	    desktopPane.setBackground(Color.BLACK);
	    add(desktopPane, BorderLayout.CENTER);
	    
	   
	    
	}//constructor

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Alumno alumno=new Alumno();
			AlumnoDAO alumnoDAO=new AlumnoDAO();
		    alumno.setNumControl(altaCajaNumControl.getText());
			alumno.setNombre(altaCajaNombres.getText());
			alumno.setPrimerAp(altaCajaApPaterno.getText());
			alumno.setSegundoAp(altaCajaApMaterno.getText());
		    alumno.setSemetre((byte)Integer.parseInt(altaComboSemestre.getSelectedItem().toString()));
			alumno.setCarrera(altaComboCarrera.getSelectedItem().toString());
			System.out.println(alumno);
		   System.out.println(alumnoDAO.agregarAlumno(alumno));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AlumnoDAO alumnoDAO=new AlumnoDAO();
		//Ventana Alta --------------------------------------------------------
		  //Boton agregar
		if(e.getSource()==altaBtnAgregar || enter) {
			Alumno alumno=new Alumno();
		    alumno.setNumControl(altaCajaNumControl.getText());
			alumno.setNombre(altaCajaNombres.getText());
			alumno.setPrimerAp(altaCajaApPaterno.getText());
			alumno.setSegundoAp(altaCajaApMaterno.getText());
		    alumno.setSemetre((byte)Integer.parseInt(altaComboSemestre.getSelectedItem().toString()));
			alumno.setCarrera(altaComboCarrera.getSelectedItem().toString());
			System.out.println(alumno);
		   System.out.println(alumnoDAO.agregarAlumno(alumno));
		}
		   //Boton borrar
		if (e.getSource()==altaBtnBorrar) {
			limpiarComponentes(altaCajaNumControl,altaCajaNombres,altaCajaApPaterno,altaCajaApMaterno,altaComboSemestre,altaComboCarrera);
		}  
		   //Boton cancelar
		if (e.getSource()==altaBtnCancelar) {
			internalFrameAltaAlumnos.setVisible(false);
		}
		
		if (e.getSource()==itemAltaAlumnos) {
			internalFrameAltaAlumnos.setVisible(true);
			enter=false;
		}if(e.getSource()==itemBajaAlumnos ) {
			internalFrameBajasAlumnos.setVisible(true);
		}if(e.getSource()==itemCambiosAlumnos ) {
			internalFrameModificarAlumnos.setVisible(true);
		}if(e.getSource()==itemConsultasAlumnos ) {
			internalFrameConsultasAlumnos.setVisible(true);
		}if(radioTodos.isSelected()) {
			activarComponentes(consultaCajaNombres,consultaCajaApPaterno,consultaCajaApMaterno,consultaSpinnerSemestre,consultaComboCarrera);
		}if(radioNombre.isSelected()) {
			activarComponentes(consultaCajaNombres);
			desactivarComponentes(consultaCajaApPaterno,consultaCajaApMaterno,consultaSpinnerSemestre,consultaComboCarrera);
		}if(radioApPaterno.isSelected()) {
			activarComponentes(consultaCajaApPaterno);
			desactivarComponentes(consultaCajaNombres,consultaCajaApMaterno,consultaSpinnerSemestre,consultaComboCarrera);
		}if(radioApMaterno.isSelected()) {
			activarComponentes(consultaCajaApMaterno);
			desactivarComponentes(consultaCajaNombres,consultaCajaApPaterno,consultaSpinnerSemestre,consultaComboCarrera);
		}if(radioSemestre.isSelected()) {
			activarComponentes(consultaSpinnerSemestre);
			desactivarComponentes(consultaCajaNombres,consultaCajaApPaterno,consultaCajaApMaterno,consultaComboCarrera);
		}if(radioCarrera.isSelected()) {
			activarComponentes(consultaComboCarrera);
			desactivarComponentes(consultaCajaNombres,consultaCajaApPaterno,consultaCajaApMaterno,consultaSpinnerSemestre);
		}if(e.getSource()==bajaBtnBuscar) {
			activarComponentes(bajasCajaNombres,bajasCajaApPaterno,bajasCajaApMaterno,bajasSpinnerSemestre,bajaComboCarrera);
		}
		
		//Boton agregar alumnos
		
	}
	

	
	public void activarComponentes(JComponent ...componentes) {
		for (JComponent c : componentes) {
			if(c instanceof JTextField)
               c.setEnabled(true);
			if (c instanceof JSpinner)
				c.setEnabled(true);
			if(c instanceof JComboBox) 
				c.setEnabled(true);
		}
	}
		public void desactivarComponentes(JComponent ...componentes) {
			for (JComponent c : componentes) {
				if(c instanceof JTextField)
	               c.setEnabled(false);
				if (c instanceof JSpinner)
					c.setEnabled(false);
				if(c instanceof JComboBox) 
					c.setEnabled(false);
			}
	}
		
		public void limpiarComponentes(JComponent ...componentes) {
			for (JComponent c : componentes) {
				if(c instanceof JTextField)
	               ((JTextField) c).setText("");
				if (c instanceof JSpinner)
					((JSpinner) c).setValue(0);
				if(c instanceof JComboBox) 
					((JComboBox) c).setSelectedIndex(0);
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