
package userInterface;

import controllers.Facade;
import dao.DAOException;
import entities.Company;
import entities.Day;
import entities.Guard;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import utils.NotificationUtil;


public class Main extends javax.swing.JFrame {

    private final Facade fachada;
    private List<Guard> guardsList;
    private List<Company> companiesList;
    private NewGuardModal newGuardModal = null;
    public static DefaultTableModel guardModel;
    public static DefaultTableModel companyModel;
    private static DefaultTableModel scheduleModel;
    private TableRowSorter guardSorter;
    private TableRowSorter companySorter;

    public Main() {
        initComponents();
        fachada = new Facade();
        Table_schedule.setRowHeight(30);
        try {
            listGuards();
            listCompanies();
            listScheduling();
        } catch (DAOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        Table_Guard.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                BTN_updateGuard.setEnabled(!e.equals(null));
                BTN_scheduleGuard.setEnabled(!e.equals(null));
                BTN_deleteGuard.setEnabled(!e.equals(null));
            }
        });
        guardSorter = new TableRowSorter<DefaultTableModel>(guardModel);
        TF_searchGuard.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String searchText = TF_searchGuard.getText();
                if (searchText.length() == 0) {
                    guardSorter.setRowFilter(null);
                } else {
                    guardSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String searchText = TF_searchGuard.getText();
                if (searchText.length() == 0) {
                    guardSorter.setRowFilter(null);
                } else {
                    guardSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String searchText = TF_searchGuard.getText();
                if (searchText.length() == 0) {
                    guardSorter.setRowFilter(null);
                } else {
                    guardSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                }
            }
        });
        Table_Guard.setRowSorter(guardSorter);
        Table_Company.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                BTN_updateCompany.setEnabled(!e.equals(null));
                BTN_scheduleCompany.setEnabled(!e.equals(null));
                BTN_deleteCompany.setEnabled(!e.equals(null));
            }
        });
        companySorter = new TableRowSorter<DefaultTableModel>(companyModel);
        TF_searchCompany.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String searchText = TF_searchCompany.getText();
                if (searchText.length() == 0) {
                    companySorter.setRowFilter(null);
                } else {
                    companySorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String searchText = TF_searchCompany.getText();
                if (searchText.length() == 0) {
                    companySorter.setRowFilter(null);
                } else {
                    companySorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        Table_Company.setRowSorter(companySorter);
    }

    private void listGuards() throws DAOException {
        //Agregamos a lista todas las personas que fueron agregadas
        guardsList = fachada.getGuards();
        //Limpiamos la tabla
        String cab[] = {"# ID", "Nombre", "Apellido", "DNI", "Telefono"};
        String dataSet[][] = {};
        guardModel = new DefaultTableModel(dataSet, cab);
        Table_Guard.setModel(guardModel);
        //Iteramos en la tabla obteniendo persona por persona
        for (int i = 0; i < guardsList.size(); i++) {
            Object data[] = {guardsList.get(i).getId(), guardsList.get(i).getFirstname(),
                guardsList.get(i).getLastname(), guardsList.get(i).getDni(),
                guardsList.get(i).getPhone()};
            guardModel.addRow(data);
        }
    }

    private void listCompanies() throws DAOException {
        //Agregamos a lista todas las personas que fueron agregadas
        companiesList = fachada.getCompanies();
        //Limpiamos la tabla
        String cab[] = {"# ID", "Nombre", "Dirección", "Telefono", "CUIT"};
        String dataSet[][] = {};
        companyModel = new DefaultTableModel(dataSet, cab);
        Table_Company.setModel(companyModel);
        //Iteramos en la tabla obteniendo persona por persona
        for (int i = 0; i < companiesList.size(); i++) {
            Object data[] = {companiesList.get(i).getId(), companiesList.get(i).getName(),
                companiesList.get(i).getAddress(), companiesList.get(i).getPhone(),
                companiesList.get(i).getCuit()};
            companyModel.addRow(data);
        }
    }
    
    private void listScheduling() throws DAOException {
        List<Day> days = fachada.getDays();
        String cab[] = {"DIA", "Companias", "Disponibilidad de guardias"};
        String dataSet[][] = {};
        scheduleModel = new DefaultTableModel(dataSet, cab);
        Table_schedule.setModel(scheduleModel);
        for (Day day : days) {
            Object data[] = {day.getName(),
                fachada.getCompanyAvailability(day)*4,
                fachada.getGuardAvailability(day)*4};
            scheduleModel.addRow(data);
        }
    }

    public void addNewRow(Object newRow) {
        if (newRow instanceof Guard) {
            Guard guard = (Guard) newRow;
            Object data[] = {guard.getId(), guard.getFirstname(), guard.getLastname(), guard.getDni(), guard.getPhone()};
            guardModel.addRow(data);
        } else {
            Company company = (Company) newRow;
            Object data[] = {company.getId(), company.getName(),
                company.getAddress(), company.getPhone(),
                company.getCuit()};
            companyModel.addRow(data);
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PNL_background = new javax.swing.JPanel();
        TabGeneral = new javax.swing.JTabbedPane();
        Panel_guard = new javax.swing.JPanel();
        jScrollPaneGuards = new javax.swing.JScrollPane();
        Table_Guard = new javax.swing.JTable();
        BTN_newGuard = new javax.swing.JButton();
        BTN_updateGuard = new javax.swing.JButton();
        BTN_consultar = new javax.swing.JButton();
        TF_searchGuard = new javax.swing.JTextField();
        LBL_SearchGuard = new javax.swing.JLabel();
        BTN_deleteGuard = new javax.swing.JButton();
        BTN_scheduleGuard = new javax.swing.JButton();
        BTN_update_guard = new javax.swing.JButton();
        Panel_company = new javax.swing.JPanel();
        jScrollPaneCompanies = new javax.swing.JScrollPane();
        Table_Company = new javax.swing.JTable();
        BTN_newCompany = new javax.swing.JButton();
        BTN_updateCompany = new javax.swing.JButton();
        BTN_query = new javax.swing.JButton();
        TF_searchCompany = new javax.swing.JTextField();
        LBL_SearchCompany = new javax.swing.JLabel();
        BTN_deleteCompany = new javax.swing.JButton();
        BTN_scheduleCompany = new javax.swing.JButton();
        BTN_update_company = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        BTN_generate_turns = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        BTN_turns_update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_schedule = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        BTN_notif = new javax.swing.JButton();
        BTN_turns = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        PNL_background.setBackground(new java.awt.Color(0, 0, 102));

        TabGeneral.setBackground(new java.awt.Color(0, 0, 102));

        Panel_guard.setBackground(new java.awt.Color(255, 255, 255));

        Table_Guard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "# ID", "Nombre", "Apellido", "DNI", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Guard.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneGuards.setViewportView(Table_Guard);

        BTN_newGuard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BTN_newGuard.setText("Nuevo guardia");
        BTN_newGuard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_newGuardActionPerformed(evt);
            }
        });

        BTN_updateGuard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BTN_updateGuard.setText("Modificar");
        BTN_updateGuard.setEnabled(false);
        BTN_updateGuard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_updateGuardActionPerformed(evt);
            }
        });

        BTN_consultar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BTN_consultar.setText("Consultar");
        BTN_consultar.setEnabled(false);

        TF_searchGuard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_searchGuardActionPerformed(evt);
            }
        });

        LBL_SearchGuard.setText("Buscar");

        BTN_deleteGuard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BTN_deleteGuard.setText("Eliminar");
        BTN_deleteGuard.setEnabled(false);
        BTN_deleteGuard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_deleteGuardActionPerformed(evt);
            }
        });

        BTN_scheduleGuard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BTN_scheduleGuard.setText("Horarios");
        BTN_scheduleGuard.setEnabled(false);
        BTN_scheduleGuard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_scheduleGuardActionPerformed(evt);
            }
        });

        BTN_update_guard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BTN_update_guard.setText("Actualizar Lista");
        BTN_update_guard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_update_guardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_guardLayout = new javax.swing.GroupLayout(Panel_guard);
        Panel_guard.setLayout(Panel_guardLayout);
        Panel_guardLayout.setHorizontalGroup(
            Panel_guardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_guardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_guardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_guardLayout.createSequentialGroup()
                        .addComponent(LBL_SearchGuard)
                        .addGap(53, 53, 53)
                        .addComponent(TF_searchGuard))
                    .addComponent(jScrollPaneGuards, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Panel_guardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel_guardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BTN_newGuard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_update_guard, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addComponent(BTN_updateGuard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BTN_deleteGuard, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_scheduleGuard, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        Panel_guardLayout.setVerticalGroup(
            Panel_guardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_guardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_guardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_searchGuard, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBL_SearchGuard)
                    .addComponent(BTN_update_guard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(Panel_guardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_guardLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(BTN_newGuard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_updateGuard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_deleteGuard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_scheduleGuard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(166, Short.MAX_VALUE))
                    .addGroup(Panel_guardLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneGuards)
                        .addContainerGap())))
        );

        TabGeneral.addTab("Gestor de guardias", Panel_guard);

        Panel_company.setBackground(new java.awt.Color(255, 255, 255));

        Table_Company.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "# ID", "Nombre", "Dirección", "Telefono", "CUIT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Company.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneCompanies.setViewportView(Table_Company);

        BTN_newCompany.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BTN_newCompany.setText("Nueva empresa");
        BTN_newCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_newCompanyActionPerformed(evt);
            }
        });

        BTN_updateCompany.setText("Modificar");
        BTN_updateCompany.setEnabled(false);
        BTN_updateCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_updateCompanyActionPerformed(evt);
            }
        });

        BTN_query.setText("Consultar");
        BTN_query.setEnabled(false);

        LBL_SearchCompany.setText("Buscar");

        BTN_deleteCompany.setText("Eliminar");
        BTN_deleteCompany.setEnabled(false);
        BTN_deleteCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_deleteCompanyActionPerformed(evt);
            }
        });

        BTN_scheduleCompany.setText("Horarios");
        BTN_scheduleCompany.setEnabled(false);
        BTN_scheduleCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_scheduleCompanyActionPerformed(evt);
            }
        });

        BTN_update_company.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BTN_update_company.setText("Actualizar Lista");
        BTN_update_company.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_update_companyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_companyLayout = new javax.swing.GroupLayout(Panel_company);
        Panel_company.setLayout(Panel_companyLayout);
        Panel_companyLayout.setHorizontalGroup(
            Panel_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_companyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_companyLayout.createSequentialGroup()
                        .addComponent(LBL_SearchCompany)
                        .addGap(53, 53, 53)
                        .addComponent(TF_searchCompany))
                    .addComponent(jScrollPaneCompanies, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BTN_newCompany, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(BTN_updateCompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_query, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_deleteCompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_scheduleCompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_update_company, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        Panel_companyLayout.setVerticalGroup(
            Panel_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_companyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_searchCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBL_SearchCompany)
                    .addComponent(BTN_update_company, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(Panel_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_companyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(BTN_newCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_updateCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_query, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_deleteCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_scheduleCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 150, Short.MAX_VALUE))
                    .addGroup(Panel_companyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneCompanies, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        TabGeneral.addTab("Gestor de empresas", Panel_company);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        BTN_generate_turns.setText("Generar turnos");
        BTN_generate_turns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_generate_turnsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Esquema de disponibilidad horaria");

        BTN_turns_update.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BTN_turns_update.setText("Actualizar");
        BTN_turns_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_turns_updateActionPerformed(evt);
            }
        });

        Table_schedule.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Table_schedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "DIA", "Companias", "Disponibilidad de guardias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table_schedule);

        BTN_notif.setText("Notificar turnos");
        BTN_notif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_notifActionPerformed(evt);
            }
        });

        BTN_turns.setText("Ver turnos activos");
        BTN_turns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_turnsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BTN_turns_update, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTN_generate_turns)
                        .addGap(189, 189, 189)
                        .addComponent(BTN_notif)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_turns)
                        .addGap(107, 107, 107))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(BTN_turns_update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_generate_turns)
                    .addComponent(BTN_notif)
                    .addComponent(BTN_turns))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        TabGeneral.addTab("Gestor de turnos", jPanel1);

        javax.swing.GroupLayout PNL_backgroundLayout = new javax.swing.GroupLayout(PNL_background);
        PNL_background.setLayout(PNL_backgroundLayout);
        PNL_backgroundLayout.setHorizontalGroup(
            PNL_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 871, Short.MAX_VALUE)
            .addGroup(PNL_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(TabGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE))
        );
        PNL_backgroundLayout.setVerticalGroup(
            PNL_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
            .addGroup(PNL_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(TabGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PNL_background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PNL_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_newGuardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_newGuardActionPerformed
        newGuardModal = new NewGuardModal(this, true);
        newGuardModal.setVisible(true);
    }//GEN-LAST:event_BTN_newGuardActionPerformed

    private void BTN_newCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_newCompanyActionPerformed
        NewCompanyModal newCompanyModal = new NewCompanyModal(this, true);
        newCompanyModal.setVisible(true);
    }//GEN-LAST:event_BTN_newCompanyActionPerformed

    private void BTN_updateGuardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_updateGuardActionPerformed
        int selectedRow = Table_Guard.getSelectedRow();
        Integer guardId = Integer.parseInt(Table_Guard.getModel().getValueAt(selectedRow, 0).toString());
        try {
            Guard guard = fachada.getGuardById(guardId);
            NewGuardModal newGuardModal = new NewGuardModal(this, true, guard);
            newGuardModal.setVisible(true);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BTN_updateGuardActionPerformed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange

    }//GEN-LAST:event_formPropertyChange

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowDeactivated

    private void TF_searchGuardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_searchGuardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_searchGuardActionPerformed

    private void BTN_updateCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_updateCompanyActionPerformed
        int selectedRow = Table_Company.getSelectedRow();
        Integer companyId = Integer.parseInt(Table_Company.getModel().getValueAt(selectedRow, 0).toString());
        try {
            Company company = fachada.getCompanyById(companyId);
            NewCompanyModal newCompanyModal = new NewCompanyModal(this, true, company);
            newCompanyModal.setVisible(true);
            BTN_updateCompany.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BTN_updateCompanyActionPerformed

    private void BTN_deleteGuardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_deleteGuardActionPerformed
        int selectedRow = Table_Guard.getSelectedRow();
        Integer guardId = Integer.parseInt(Table_Guard.getModel().getValueAt(selectedRow, 0).toString());
        try {
            Guard guard = fachada.getGuardById(guardId);
            if (JOptionPane.showConfirmDialog(this, "Esta seguro que desea eliminar el Guardia " + guard.getFirstname() + "?", "Eliminar Guardia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
                    == JOptionPane.YES_OPTION) {
                fachada.deleteGuard(guard);
                guardModel.removeRow(selectedRow);
                BTN_deleteGuard.setEnabled(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BTN_deleteGuardActionPerformed

    private void BTN_deleteCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_deleteCompanyActionPerformed
        int selectedRow = Table_Company.getSelectedRow();
        Integer companyId = Integer.parseInt(Table_Company.getModel().getValueAt(selectedRow, 0).toString());
        try {
            Company company = fachada.getCompanyById(companyId);
            if (JOptionPane.showConfirmDialog(this, "Esta seguro que desea eliminar la Empresa " + company.getName() + "?", "Eliminar Empresa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
                    == JOptionPane.YES_OPTION) {
                fachada.deleteCompany(company);
                companyModel.removeRow(selectedRow);
                BTN_deleteCompany.setEnabled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BTN_deleteCompanyActionPerformed

    private void BTN_scheduleGuardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_scheduleGuardActionPerformed
        int selectedRow = Table_Guard.getSelectedRow();
        Integer guardId = Integer.parseInt(Table_Guard.getModel().getValueAt(selectedRow, 0).toString());
        try {
            Guard guard = fachada.getGuardById(guardId);
            NewSchedule newScheduleModal = new NewSchedule(this, true, guard);
            newScheduleModal.setVisible(true);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BTN_scheduleGuardActionPerformed

    private void BTN_scheduleCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_scheduleCompanyActionPerformed
        int selectedRow = Table_Company.getSelectedRow();
        Integer companyId = Integer.parseInt(Table_Company.getModel().getValueAt(selectedRow, 0).toString());
        try {
            Company company = fachada.getCompanyById(companyId);
            NewSchedule newScheduleModal = new NewSchedule(this, true, company);
            newScheduleModal.setVisible(true);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BTN_scheduleCompanyActionPerformed

    private void BTN_update_companyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_update_companyActionPerformed
        try {
            listCompanies();
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BTN_update_companyActionPerformed

    private void BTN_update_guardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_update_guardActionPerformed
        try {
            listGuards();
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BTN_update_guardActionPerformed

    private void BTN_generate_turnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_generate_turnsActionPerformed
       TurnsGestor gestor = new TurnsGestor(this, true);
       gestor.setVisible(true);
    }//GEN-LAST:event_BTN_generate_turnsActionPerformed

    private void BTN_turns_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_turns_updateActionPerformed
        try {
            listScheduling();
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BTN_turns_updateActionPerformed

    private void BTN_notifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_notifActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Esta seguro que desea realizar las notificaciones?", "Notificaciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
                    == JOptionPane.YES_OPTION) {
        NotificationUtil nUtil = new NotificationUtil();
            try {
                nUtil.SendNotifications();
                JOptionPane.showMessageDialog(null, "Turnos notificados");
            } catch (DAOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BTN_notifActionPerformed

    private void BTN_turnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_turnsActionPerformed
        TurnsView turnv = new TurnsView(this, true);
        turnv.setVisible(true);
    }//GEN-LAST:event_BTN_turnsActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_consultar;
    private javax.swing.JButton BTN_deleteCompany;
    private javax.swing.JButton BTN_deleteGuard;
    private javax.swing.JButton BTN_generate_turns;
    private javax.swing.JButton BTN_newCompany;
    private javax.swing.JButton BTN_newGuard;
    private javax.swing.JButton BTN_notif;
    private javax.swing.JButton BTN_query;
    private javax.swing.JButton BTN_scheduleCompany;
    private javax.swing.JButton BTN_scheduleGuard;
    private javax.swing.JButton BTN_turns;
    private javax.swing.JButton BTN_turns_update;
    private javax.swing.JButton BTN_updateCompany;
    private javax.swing.JButton BTN_updateGuard;
    private javax.swing.JButton BTN_update_company;
    private javax.swing.JButton BTN_update_guard;
    private javax.swing.JLabel LBL_SearchCompany;
    private javax.swing.JLabel LBL_SearchGuard;
    private javax.swing.JPanel PNL_background;
    private javax.swing.JPanel Panel_company;
    private javax.swing.JPanel Panel_guard;
    private javax.swing.JTextField TF_searchCompany;
    private javax.swing.JTextField TF_searchGuard;
    private javax.swing.JTabbedPane TabGeneral;
    private javax.swing.JTable Table_Company;
    private javax.swing.JTable Table_Guard;
    private javax.swing.JTable Table_schedule;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneCompanies;
    private javax.swing.JScrollPane jScrollPaneGuards;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
