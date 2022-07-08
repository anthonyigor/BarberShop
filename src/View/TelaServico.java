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
public class TelaServico extends javax.swing.JInternalFrame {
Connection conexao = null;
PreparedStatement pst = null;
ResultSet rs = null;
    /**
     * Creates new form TelaCliente
     */
    public TelaServico() {
        initComponents();
        conexao=moduloConexao.conector();
    }

    // metodo para adicionar 
    private void adicionar(){
        String sql = "insert into servicoCode(servDesc,servPreco) values(?,?)";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,servicoDescricao.getText());
            pst.setString(2,servicoPreco.getText());
            
            
            if((servicoDescricao.getText().isEmpty()) || (servicoPreco.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");
            }
            else{
                int adicionado = pst.executeUpdate();
                
                
                if(adicionado > 0){
                    JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!");
                    servicoDescricao.setText(null);
                    servicoPreco.setText(null);
                    servicoID.setText(null);        
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    
    }
    
    //metodo de pesquisa
    
    
    private void pesquisar_servico(){
        String sql= "select servID as ID, servDesc as Descricao, servPreco as Preco from servicoCode where servDesc like ?";
        try {
            pst = conexao.prepareStatement(sql);
             
            //passando a informação para a caixa de pesquisa
            // atenção ao "%" - continuação da string ? acima
            
            pst.setString(1,servicoPesquisa.getText() + "%");
            rs=pst.executeQuery();
            
            servicoTabela.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void vincularCampos() {
        int setar = servicoTabela.getSelectedRow();
        servicoID.setText(servicoTabela.getModel().getValueAt(setar, 0).toString());
        servicoDescricao.setText(servicoTabela.getModel().getValueAt(setar, 1).toString());
        servicoPreco.setText(servicoTabela.getModel().getValueAt(setar, 2).toString());
        //desabilitar botão add
        servicoAdd.setEnabled(false);
    }
            
        
        
        
        // metodo para alterar os campos
         private void alterar(){
        String sql = "update servicoCode set servDesc=?,servPreco=? where servID=?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,servicoDescricao.getText());
            pst.setString(2,servicoPreco.getText());
            pst.setString(3,servicoID.getText());
            
            if((servicoDescricao.getText().isEmpty()) || (servicoPreco.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");
            }
            else{
                int adicionado = pst.executeUpdate();
                
                
                if(adicionado > 0){
                    JOptionPane.showMessageDialog(null, "Dados alterados com Sucesso!");
                    servicoDescricao.setText(null);
                    servicoPreco.setText(null);        
                    servicoAdd.setEnabled(true);
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    
    }
    // metodo para alterar os campos
        private void apagar() {
        int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar este servico?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            String sql = "delete from servicoCode where servID=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, servicoID.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario apagado!");
                        servicoDescricao.setText(null);
                        servicoPreco.setText(null);
                        servicoAdd.setEnabled(true);
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
        jLabel3 = new javax.swing.JLabel();
        servicoPreco = new javax.swing.JTextField();
        servicoDescricao = new javax.swing.JTextField();
        servicoPesquisa = new javax.swing.JTextField();
        servicoBotaoPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        servicoTabela = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        servicoAdd = new javax.swing.JButton();
        servicoEdit = new javax.swing.JButton();
        servicoDell = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        servicoID = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Serviços");
        setPreferredSize(new java.awt.Dimension(100, 100));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("*Preço:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("*Descricão:");

        servicoPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicoPrecoActionPerformed(evt);
            }
        });

        servicoDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicoDescricaoActionPerformed(evt);
            }
        });

        servicoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicoPesquisaActionPerformed(evt);
            }
        });
        servicoPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                servicoPesquisaKeyReleased(evt);
            }
        });

        servicoBotaoPesquisar.setText("Pesquisar");

        servicoTabela = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        servicoTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Descricao", "Preco"
            }
        ));
        servicoTabela.setToolTipText("");
        servicoTabela.setFocusable(false);
        servicoTabela.getTableHeader().setReorderingAllowed(false);
        servicoTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servicoTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(servicoTabela);

        jLabel8.setText("* CAMPOS OBRIGATORIOS");

        servicoAdd.setText("ADICIONAR");
        servicoAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicoAddActionPerformed(evt);
            }
        });

        servicoEdit.setText("EDITAR");
        servicoEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicoEditActionPerformed(evt);
            }
        });

        servicoDell.setText("REMOVER");
        servicoDell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicoDellActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Id do Servico:");

        servicoID.setEnabled(false);
        servicoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicoIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(servicoAdd)
                .addGap(39, 39, 39)
                .addComponent(servicoEdit)
                .addGap(49, 49, 49)
                .addComponent(servicoDell)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(servicoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(servicoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(servicoID, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(servicoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(servicoBotaoPesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                .addComponent(jLabel8)))))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servicoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servicoBotaoPesquisar)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servicoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servicoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servicoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servicoAdd)
                    .addComponent(servicoEdit)
                    .addComponent(servicoDell))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        setBounds(0, 0, 850, 530);
    }// </editor-fold>//GEN-END:initComponents

    private void servicoPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicoPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servicoPrecoActionPerformed

    private void servicoDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicoDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servicoDescricaoActionPerformed

    private void servicoEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicoEditActionPerformed
        // metodos para alterar
        alterar();
    }//GEN-LAST:event_servicoEditActionPerformed

    private void servicoAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicoAddActionPerformed
        // adicionando clientes
        adicionar();
    }//GEN-LAST:event_servicoAddActionPerformed

    private void servicoPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_servicoPesquisaKeyReleased
        // Evento para digitar em tempo real:
        pesquisar_servico();
    }//GEN-LAST:event_servicoPesquisaKeyReleased

    private void servicoTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servicoTabelaMouseClicked
        // vincular tabela com os campos
        vincularCampos();
    }//GEN-LAST:event_servicoTabelaMouseClicked

    private void servicoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicoIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servicoIDActionPerformed

    private void servicoDellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicoDellActionPerformed
        // remove um usuario
        apagar();
        
    }//GEN-LAST:event_servicoDellActionPerformed

    private void servicoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicoPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servicoPesquisaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton servicoAdd;
    private javax.swing.JButton servicoBotaoPesquisar;
    private javax.swing.JButton servicoDell;
    private javax.swing.JTextField servicoDescricao;
    private javax.swing.JButton servicoEdit;
    private javax.swing.JTextField servicoID;
    private javax.swing.JTextField servicoPesquisa;
    private javax.swing.JTextField servicoPreco;
    private javax.swing.JTable servicoTabela;
    // End of variables declaration//GEN-END:variables
}
