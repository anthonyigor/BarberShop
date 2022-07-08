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
public class TelaBarbeiro extends javax.swing.JInternalFrame {
Connection conexao = null;
PreparedStatement pst = null;
ResultSet rs = null;
    /**
     * Creates new form TelaCliente
     */
    public TelaBarbeiro() {
        initComponents();
        conexao=moduloConexao.conector();
    }

    // metodo para adicionar 
    private void adicionar(){
        String sql = "insert into barber(registro_carteira ,barbeiro_nome ,cpf ,telefone ,data_de_nascimento ,email) values(?,?,?,?,?,?)";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,barbeiroCarteira.getText());
            pst.setString(2,nomeBarbeiro.getText());
            pst.setString(3,barbeiroCPF.getText());
            pst.setString(4,barbeiroFone.getText());
            pst.setString(5,barbeiroBorndate.getText());
            pst.setString(6,barbeiroemail.getText());
            
            
            if((barbeiroCarteira.getText().isEmpty()) || (barbeiroCPF.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");
            }
            else{
                int adicionado = pst.executeUpdate();
                
                
                if(adicionado > 0){
                    JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!");
                    barbeiroCarteira.setText(null);
                    nomeBarbeiro.setText(null);
                    barbeiroCPF.setText(null);
                    barbeiroFone.setText(null);
                    barbeiroBorndate.setText(null);
                    barbeiroemail.setText(null);        
                    barbeiroID.setText(null);        
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    
    }
    
    //metodo de pesquisa
    
    
    private void pesquisar_barbeiro(){
        String sql= "select id as ID, registro_carteira as Registro_na_carteira, barbeiro_nome as Nome, cpf as CPF,telefone as Telefone, data_de_nascimento as Data_de_nascimento, email as Email from barber where barbeiro_nome like ?";
        try {
            pst = conexao.prepareStatement(sql);
             
            //passando a informação para a caixa de pesquisa
            // atenção ao "%" - continuação da string ? acima
            
            pst.setString(1,barbeiroPesquisa.getText() + "%");
            rs=pst.executeQuery();
            
            barbeiroTabela.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void vincularCampos() {
        int setar = barbeiroTabela.getSelectedRow();
        barbeiroID.setText(barbeiroTabela.getModel().getValueAt(setar, 0).toString());
        barbeiroCarteira.setText(barbeiroTabela.getModel().getValueAt(setar, 1).toString());
        nomeBarbeiro.setText(barbeiroTabela.getModel().getValueAt(setar, 2).toString());
        barbeiroCPF.setText(barbeiroTabela.getModel().getValueAt(setar, 3).toString());
        barbeiroFone.setText(barbeiroTabela.getModel().getValueAt(setar, 4).toString());
        barbeiroBorndate.setText(barbeiroTabela.getModel().getValueAt(setar, 5).toString());
        barbeiroemail.setText(barbeiroTabela.getModel().getValueAt(setar, 6).toString());
        //desabilitar botão add
        barbeiroAdd.setEnabled(false);
    }
            
        
        
        
        // metodo para alterar os campos
         private void alterar(){
        String sql = "update barber set registro_carteira=?,barbeiro_nome=?,cpf=?,telefone=?,data_de_nascimento=?,email=? where id=?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,barbeiroCarteira.getText());
            pst.setString(2,nomeBarbeiro.getText());
            pst.setString(3,barbeiroCPF.getText());
            pst.setString(4,barbeiroFone.getText());
            pst.setString(5,barbeiroBorndate.getText());
            pst.setString(6,barbeiroemail.getText());
            pst.setString(7,barbeiroID.getText());
            
            if((barbeiroCarteira.getText().isEmpty()) || (barbeiroCPF.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");
            }
            else{
                int adicionado = pst.executeUpdate();
                
                
                if(adicionado > 0){
                    JOptionPane.showMessageDialog(null, "Dados alterados com Sucesso!");
                    barbeiroCarteira.setText(null);
                    nomeBarbeiro.setText(null);
                    barbeiroCPF.setText(null);
                    barbeiroFone.setText(null);
                    barbeiroBorndate.setText(null);
                    barbeiroemail.setText(null);          
                    barbeiroAdd.setEnabled(true);
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    
    }
    // metodo para alterar os campos
        private void apagar() {
        int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar este barbeiro?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            String sql = "delete from barber where id=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, barbeiroID.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario apagado!");
                        barbeiroCarteira.setText(null);
                        nomeBarbeiro.setText(null);
                        barbeiroCPF.setText(null);
                        barbeiroFone.setText(null);
                        barbeiroBorndate.setText(null);
                        barbeiroemail.setText(null);
                        barbeiroAdd.setEnabled(true);
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
        jLabel7 = new javax.swing.JLabel();
        nomeBarbeiro = new javax.swing.JTextField();
        barbeiroCarteira = new javax.swing.JTextField();
        barbeiroCPF = new javax.swing.JTextField();
        barbeiroFone = new javax.swing.JTextField();
        barbeiroBorndate = new javax.swing.JTextField();
        barbeiroemail = new javax.swing.JTextField();
        barbeiroPesquisa = new javax.swing.JTextField();
        barbeiroBotaoPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        barbeiroTabela = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        barbeiroAdd = new javax.swing.JButton();
        barbeiroEdit = new javax.swing.JButton();
        barbeiroDell = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        barbeiroID = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Barbeiros");
        setPreferredSize(new java.awt.Dimension(100, 100));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("*Nome:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("*CPF: ");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("*Carteira:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Telefone:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("E-mail:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Data de nascimento:");

        nomeBarbeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeBarbeiroActionPerformed(evt);
            }
        });

        barbeiroCarteira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barbeiroCarteiraActionPerformed(evt);
            }
        });

        barbeiroCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barbeiroCPFActionPerformed(evt);
            }
        });

        barbeiroFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barbeiroFoneActionPerformed(evt);
            }
        });

        barbeiroBorndate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barbeiroBorndateActionPerformed(evt);
            }
        });

        barbeiroemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barbeiroemailActionPerformed(evt);
            }
        });

        barbeiroPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barbeiroPesquisaActionPerformed(evt);
            }
        });
        barbeiroPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                barbeiroPesquisaKeyReleased(evt);
            }
        });

        barbeiroBotaoPesquisar.setText("Pesquisar");

        barbeiroTabela = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        barbeiroTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", " Registro_na_carteira", "Nome", "CPF", "Telefone", "Data_de_nascimento", "Email"
            }
        ));
        barbeiroTabela.setFocusable(false);
        barbeiroTabela.getTableHeader().setReorderingAllowed(false);
        barbeiroTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbeiroTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(barbeiroTabela);

        jLabel8.setText("* CAMPOS OBRIGATORIOS");

        barbeiroAdd.setText("ADICIONAR");
        barbeiroAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barbeiroAddActionPerformed(evt);
            }
        });

        barbeiroEdit.setText("EDITAR");
        barbeiroEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barbeiroEditActionPerformed(evt);
            }
        });

        barbeiroDell.setText("REMOVER");
        barbeiroDell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barbeiroDellActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Id do Barbeiro:");

        barbeiroID.setEnabled(false);
        barbeiroID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barbeiroIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barbeiroCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeBarbeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barbeiroFone, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barbeiroBorndate, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barbeiroemail, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barbeiroCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barbeiroID, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(barbeiroPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(barbeiroBotaoPesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                .addComponent(jLabel8)))))
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(barbeiroAdd)
                .addGap(39, 39, 39)
                .addComponent(barbeiroEdit)
                .addGap(49, 49, 49)
                .addComponent(barbeiroDell)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barbeiroPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barbeiroBotaoPesquisar)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barbeiroID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barbeiroCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeBarbeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barbeiroCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barbeiroFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barbeiroBorndate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barbeiroemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barbeiroAdd)
                    .addComponent(barbeiroEdit)
                    .addComponent(barbeiroDell))
                .addGap(20, 20, 20))
        );

        setBounds(0, 0, 850, 530);
    }// </editor-fold>//GEN-END:initComponents

    private void nomeBarbeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeBarbeiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeBarbeiroActionPerformed

    private void barbeiroCarteiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barbeiroCarteiraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barbeiroCarteiraActionPerformed

    private void barbeiroCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barbeiroCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barbeiroCPFActionPerformed

    private void barbeiroFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barbeiroFoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barbeiroFoneActionPerformed

    private void barbeiroBorndateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barbeiroBorndateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barbeiroBorndateActionPerformed

    private void barbeiroemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barbeiroemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barbeiroemailActionPerformed

    private void barbeiroEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barbeiroEditActionPerformed
        // metodos para alterar
        alterar();
    }//GEN-LAST:event_barbeiroEditActionPerformed

    private void barbeiroAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barbeiroAddActionPerformed
        // adicionando clientes
        adicionar();
    }//GEN-LAST:event_barbeiroAddActionPerformed

    private void barbeiroPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barbeiroPesquisaKeyReleased
        // Evento para digitar em tempo real:
        pesquisar_barbeiro(); 
    }//GEN-LAST:event_barbeiroPesquisaKeyReleased

    private void barbeiroTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbeiroTabelaMouseClicked
        // vincular tabela com os campos
        vincularCampos();
    }//GEN-LAST:event_barbeiroTabelaMouseClicked

    private void barbeiroIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barbeiroIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barbeiroIDActionPerformed

    private void barbeiroDellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barbeiroDellActionPerformed
        // remove um usuario
        apagar();
        
    }//GEN-LAST:event_barbeiroDellActionPerformed

    private void barbeiroPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barbeiroPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barbeiroPesquisaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton barbeiroAdd;
    private javax.swing.JTextField barbeiroBorndate;
    private javax.swing.JButton barbeiroBotaoPesquisar;
    private javax.swing.JTextField barbeiroCPF;
    private javax.swing.JTextField barbeiroCarteira;
    private javax.swing.JButton barbeiroDell;
    private javax.swing.JButton barbeiroEdit;
    private javax.swing.JTextField barbeiroFone;
    private javax.swing.JTextField barbeiroID;
    private javax.swing.JTextField barbeiroPesquisa;
    private javax.swing.JTable barbeiroTabela;
    private javax.swing.JTextField barbeiroemail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeBarbeiro;
    // End of variables declaration//GEN-END:variables
}
