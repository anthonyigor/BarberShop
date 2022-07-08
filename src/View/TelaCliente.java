/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;
import java.sql.*;
import br.com.barbearia.dal.moduloConexao;
import javax.swing.JOptionPane;
// Import para recursos da biblioteca
import net.proteanit.sql.DbUtils;

/**
 *
 * @author LegendarioP
 */
public class TelaCliente extends javax.swing.JInternalFrame {
Connection conexao = null;
PreparedStatement pst = null;
ResultSet rs = null;
    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
        conexao=moduloConexao.conector();
    }

    // metodo para adicionar 
    private void adicionar(){
        String sql = "insert into tbclientes(nome,endereco,fonecli,emailcli,rgcli,datanascimento,cpfCli) values(?,?,?,?,?,?,?)";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,clienteNome.getText());
            pst.setString(2,clienteEndereco.getText());
            pst.setString(3,clienteFone.getText());
            pst.setString(4,clienteEmail.getText());
            pst.setString(5,clienteRG.getText());
            pst.setString(6,clienteBorndate.getText());
            pst.setString(7,clienteCPF.getText());
            
            if((clienteNome.getText().isEmpty()) || (clienteFone.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");
            }
            else{
                int adicionado = pst.executeUpdate();
                
                
                if(adicionado > 0){
                    JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!");
                    clienteNome.setText(null);
                    clienteEndereco.setText(null);
                    clienteFone.setText(null);
                    clienteEmail.setText(null);
                    clienteRG.setText(null);
                    clienteBorndate.setText(null);        
                    clienteCPF.setText(null);        
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    
    }
    
    //metodo de pesquisa
    
    
    private void pesquisar_cliente(){
        String sql= "select idcliente as ID, nome as Nome, endereco as endereco, fonecli as Telefone, emailcli as Email,rgcli as RG, datanascimento as Data_de_Nascimento, cpfCli as CPF from tbclientes where nome like ?";
        try {
            pst = conexao.prepareStatement(sql);
             
            //passando a informação para a caixa de pesquisa
            // atenção ao "%" - continuação da string ? acima
            
            pst.setString(1,clientePesquisa.getText() + "%");
            rs=pst.executeQuery();
            
            clienteTabela.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void vincularCampos() {
        int setar = clienteTabela.getSelectedRow();
        clienteID.setText(clienteTabela.getModel().getValueAt(setar, 0).toString());
        clienteNome.setText(clienteTabela.getModel().getValueAt(setar, 1).toString());
        clienteEndereco.setText(clienteTabela.getModel().getValueAt(setar, 2).toString());
        clienteFone.setText(clienteTabela.getModel().getValueAt(setar, 3).toString());
        clienteEmail.setText(clienteTabela.getModel().getValueAt(setar, 4).toString());
        clienteRG.setText(clienteTabela.getModel().getValueAt(setar, 5).toString());
        clienteBorndate.setText(clienteTabela.getModel().getValueAt(setar, 6).toString());
        clienteCPF.setText(clienteTabela.getModel().getValueAt(setar, 7).toString());
        //desabilitar botão add
        clienteAdd.setEnabled(false);
    }
            
        
        
        
        // metodo para alterar os campos
         private void alterar(){
        String sql = "update tbclientes set nome=?,endereco=?,fonecli=?,emailcli=?,rgcli=?,datanascimento=?,cpfCli=? where idcliente=?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,clienteNome.getText());
            pst.setString(2,clienteEndereco.getText());
            pst.setString(3,clienteFone.getText());
            pst.setString(4,clienteEmail.getText());
            pst.setString(5,clienteRG.getText());
            pst.setString(6,clienteBorndate.getText());
            pst.setString(7,clienteCPF.getText());
            pst.setString(8,clienteID.getText());
            
            if((clienteNome.getText().isEmpty()) || (clienteFone.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");
            }
            else{
                int adicionado = pst.executeUpdate();
                
                
                if(adicionado > 0){
                    JOptionPane.showMessageDialog(null, "Dados alterados com Sucesso!");
                    clienteNome.setText(null);
                    clienteEndereco.setText(null);
                    clienteFone.setText(null);
                    clienteEmail.setText(null);
                    clienteRG.setText(null);
                    clienteBorndate.setText(null);        
                    clienteCPF.setText(null);    
                    clienteAdd.setEnabled(true);
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    
    }
    // metodo para alterar os campos
        private void apagar() {
        int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar este cliente?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            String sql = "delete from tbclientes where idcliente=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, clienteID.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario apagado!");
                        clienteNome.setText(null);
                        clienteEndereco.setText(null);
                        clienteFone.setText(null);
                        clienteEmail.setText(null);
                        clienteRG.setText(null);
                        clienteBorndate.setText(null);
                        clienteCPF.setText(null);
                        clienteAdd.setEnabled(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
            
            
        
        
    
    
    
    }   
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        clienteEndereco = new javax.swing.JTextField();
        clienteNome = new javax.swing.JTextField();
        clienteFone = new javax.swing.JTextField();
        clienteEmail = new javax.swing.JTextField();
        clienteRG = new javax.swing.JTextField();
        clienteBorndate = new javax.swing.JTextField();
        clienteCPF = new javax.swing.JTextField();
        clientePesquisa = new javax.swing.JTextField();
        clienteBotaoPesquisar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        clienteAdd = new javax.swing.JButton();
        clienteEdit = new javax.swing.JButton();
        clienteDell = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        clienteID = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        clienteTabela = new javax.swing.JTable();

        setClosable(true);
        setTitle("Clientes");
        setPreferredSize(new java.awt.Dimension(100, 100));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Endereco: ");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Telefone*:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Nome*:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("E-mail:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Data de nascimento:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("CPF:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Rg(opcional):");

        clienteEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteEnderecoActionPerformed(evt);
            }
        });

        clienteNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteNomeActionPerformed(evt);
            }
        });

        clienteFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteFoneActionPerformed(evt);
            }
        });

        clienteEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteEmailActionPerformed(evt);
            }
        });

        clienteRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteRGActionPerformed(evt);
            }
        });

        clienteBorndate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteBorndateActionPerformed(evt);
            }
        });

        clienteCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteCPFActionPerformed(evt);
            }
        });

        clientePesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clientePesquisaKeyReleased(evt);
            }
        });

        clienteBotaoPesquisar.setText("Pesquisar");

        jLabel8.setText("* CAMPOS OBRIGATORIOS");

        clienteAdd.setText("ADICIONAR");
        clienteAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteAddActionPerformed(evt);
            }
        });

        clienteEdit.setText("EDITAR");
        clienteEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteEditActionPerformed(evt);
            }
        });

        clienteDell.setText("REMOVER");
        clienteDell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteDellActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Id do cliente: ");

        clienteID.setEnabled(false);
        clienteID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteIDActionPerformed(evt);
            }
        });

        clienteTabela = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        clienteTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Endereco", "Telefone", "Email", "RG", "Data_de_Nascimento", "CPF"
            }
        ));
        clienteTabela.setToolTipText("");
        clienteTabela.setFocusable(false);
        clienteTabela.getTableHeader().setReorderingAllowed(false);
        clienteTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clienteTabelaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(clienteTabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(45, 45, 45)
                                    .addComponent(jLabel7))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(83, 83, 83)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clienteFone, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clienteEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clienteEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clienteRG, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clienteBorndate, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clienteCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clienteID, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(clienteAdd)
                                .addGap(39, 39, 39)
                                .addComponent(clienteEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clienteDell))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clientePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clienteBotaoPesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                                .addComponent(jLabel8))
                            .addComponent(jScrollPane2))))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clienteBotaoPesquisar)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clienteID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clienteEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clienteFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clienteEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clienteRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clienteBorndate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clienteCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteAdd)
                    .addComponent(clienteEdit)
                    .addComponent(clienteDell))
                .addGap(20, 20, 20))
        );

        setBounds(0, 0, 856, 549);
    }// </editor-fold>//GEN-END:initComponents

    private void clienteEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteEnderecoActionPerformed

    private void clienteNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteNomeActionPerformed

    private void clienteFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteFoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteFoneActionPerformed

    private void clienteEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteEmailActionPerformed

    private void clienteRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteRGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteRGActionPerformed

    private void clienteBorndateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteBorndateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteBorndateActionPerformed

    private void clienteCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteCPFActionPerformed

    private void clienteEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteEditActionPerformed
        // metodos para alterar
        alterar();
    }//GEN-LAST:event_clienteEditActionPerformed

    private void clienteAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteAddActionPerformed
        // adicionando clientes
        adicionar();
    }//GEN-LAST:event_clienteAddActionPerformed

    private void clientePesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clientePesquisaKeyReleased
        // Evento para digitar em tempo real:
        pesquisar_cliente(); 
    }//GEN-LAST:event_clientePesquisaKeyReleased

    private void clienteIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteIDActionPerformed

    private void clienteDellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteDellActionPerformed
        // remove um usuario
        apagar();
        
    }//GEN-LAST:event_clienteDellActionPerformed

    private void clienteTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteTabelaMouseClicked
        // TODO add your handling code here:
        vincularCampos();
    }//GEN-LAST:event_clienteTabelaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clienteAdd;
    private javax.swing.JTextField clienteBorndate;
    private javax.swing.JButton clienteBotaoPesquisar;
    private javax.swing.JTextField clienteCPF;
    private javax.swing.JButton clienteDell;
    private javax.swing.JButton clienteEdit;
    private javax.swing.JTextField clienteEmail;
    private javax.swing.JTextField clienteEndereco;
    private javax.swing.JTextField clienteFone;
    private javax.swing.JTextField clienteID;
    private javax.swing.JTextField clienteNome;
    private javax.swing.JTextField clientePesquisa;
    private javax.swing.JTextField clienteRG;
    private javax.swing.JTable clienteTabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
