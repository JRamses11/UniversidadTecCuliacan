
namespace CitasMedicasGUI
{
    partial class frmConsultaIndividualCitas
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lblClaveCita = new System.Windows.Forms.Label();
            this.lblClaveMedico = new System.Windows.Forms.Label();
            this.lblFecha = new System.Windows.Forms.Label();
            this.lblHora = new System.Windows.Forms.Label();
            this.lblNombrePaciente = new System.Windows.Forms.Label();
            this.lblTelefonoPaciente = new System.Windows.Forms.Label();
            this.lblObservaciones = new System.Windows.Forms.Label();
            this.txtClaveMedico = new System.Windows.Forms.TextBox();
            this.txtFecha = new System.Windows.Forms.TextBox();
            this.txtHora = new System.Windows.Forms.TextBox();
            this.txtNombrePaciente = new System.Windows.Forms.TextBox();
            this.txtTelefonoPaciente = new System.Windows.Forms.TextBox();
            this.txtObservaciones = new System.Windows.Forms.TextBox();
            this.cmbClaveCita = new System.Windows.Forms.ComboBox();
            this.lblEncabezado = new System.Windows.Forms.Label();
            this.lblNombreMedico = new System.Windows.Forms.Label();
            this.txtNombreMedico = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // lblClaveCita
            // 
            this.lblClaveCita.AutoSize = true;
            this.lblClaveCita.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblClaveCita.Location = new System.Drawing.Point(71, 122);
            this.lblClaveCita.Name = "lblClaveCita";
            this.lblClaveCita.Size = new System.Drawing.Size(72, 18);
            this.lblClaveCita.TabIndex = 0;
            this.lblClaveCita.Text = "Clave cita";
            // 
            // lblClaveMedico
            // 
            this.lblClaveMedico.AutoSize = true;
            this.lblClaveMedico.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblClaveMedico.Location = new System.Drawing.Point(45, 160);
            this.lblClaveMedico.Name = "lblClaveMedico";
            this.lblClaveMedico.Size = new System.Drawing.Size(98, 18);
            this.lblClaveMedico.TabIndex = 1;
            this.lblClaveMedico.Text = "Clave medico";
            // 
            // lblFecha
            // 
            this.lblFecha.AutoSize = true;
            this.lblFecha.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblFecha.Location = new System.Drawing.Point(94, 237);
            this.lblFecha.Name = "lblFecha";
            this.lblFecha.Size = new System.Drawing.Size(49, 18);
            this.lblFecha.TabIndex = 2;
            this.lblFecha.Text = "Fecha";
            // 
            // lblHora
            // 
            this.lblHora.AutoSize = true;
            this.lblHora.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblHora.Location = new System.Drawing.Point(102, 276);
            this.lblHora.Name = "lblHora";
            this.lblHora.Size = new System.Drawing.Size(41, 18);
            this.lblHora.TabIndex = 3;
            this.lblHora.Text = "Hora";
            // 
            // lblNombrePaciente
            // 
            this.lblNombrePaciente.AutoSize = true;
            this.lblNombrePaciente.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblNombrePaciente.Location = new System.Drawing.Point(22, 313);
            this.lblNombrePaciente.Name = "lblNombrePaciente";
            this.lblNombrePaciente.Size = new System.Drawing.Size(121, 18);
            this.lblNombrePaciente.TabIndex = 4;
            this.lblNombrePaciente.Text = "Nombre paciente";
            // 
            // lblTelefonoPaciente
            // 
            this.lblTelefonoPaciente.AutoSize = true;
            this.lblTelefonoPaciente.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblTelefonoPaciente.Location = new System.Drawing.Point(18, 350);
            this.lblTelefonoPaciente.Name = "lblTelefonoPaciente";
            this.lblTelefonoPaciente.Size = new System.Drawing.Size(125, 18);
            this.lblTelefonoPaciente.TabIndex = 5;
            this.lblTelefonoPaciente.Text = "Telefono paciente";
            // 
            // lblObservaciones
            // 
            this.lblObservaciones.AutoSize = true;
            this.lblObservaciones.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblObservaciones.Location = new System.Drawing.Point(35, 384);
            this.lblObservaciones.Name = "lblObservaciones";
            this.lblObservaciones.Size = new System.Drawing.Size(108, 18);
            this.lblObservaciones.TabIndex = 6;
            this.lblObservaciones.Text = "Observaciones";
            // 
            // txtClaveMedico
            // 
            this.txtClaveMedico.Enabled = false;
            this.txtClaveMedico.Location = new System.Drawing.Point(161, 158);
            this.txtClaveMedico.Name = "txtClaveMedico";
            this.txtClaveMedico.Size = new System.Drawing.Size(133, 20);
            this.txtClaveMedico.TabIndex = 8;
            // 
            // txtFecha
            // 
            this.txtFecha.Enabled = false;
            this.txtFecha.Location = new System.Drawing.Point(161, 238);
            this.txtFecha.Name = "txtFecha";
            this.txtFecha.Size = new System.Drawing.Size(133, 20);
            this.txtFecha.TabIndex = 9;
            // 
            // txtHora
            // 
            this.txtHora.Enabled = false;
            this.txtHora.Location = new System.Drawing.Point(161, 277);
            this.txtHora.Name = "txtHora";
            this.txtHora.Size = new System.Drawing.Size(133, 20);
            this.txtHora.TabIndex = 10;
            // 
            // txtNombrePaciente
            // 
            this.txtNombrePaciente.Enabled = false;
            this.txtNombrePaciente.Location = new System.Drawing.Point(161, 314);
            this.txtNombrePaciente.Name = "txtNombrePaciente";
            this.txtNombrePaciente.Size = new System.Drawing.Size(133, 20);
            this.txtNombrePaciente.TabIndex = 11;
            // 
            // txtTelefonoPaciente
            // 
            this.txtTelefonoPaciente.Enabled = false;
            this.txtTelefonoPaciente.Location = new System.Drawing.Point(161, 348);
            this.txtTelefonoPaciente.Name = "txtTelefonoPaciente";
            this.txtTelefonoPaciente.Size = new System.Drawing.Size(133, 20);
            this.txtTelefonoPaciente.TabIndex = 12;
            // 
            // txtObservaciones
            // 
            this.txtObservaciones.Enabled = false;
            this.txtObservaciones.Location = new System.Drawing.Point(161, 384);
            this.txtObservaciones.Name = "txtObservaciones";
            this.txtObservaciones.Size = new System.Drawing.Size(133, 20);
            this.txtObservaciones.TabIndex = 13;
            // 
            // cmbClaveCita
            // 
            this.cmbClaveCita.FormattingEnabled = true;
            this.cmbClaveCita.Location = new System.Drawing.Point(161, 122);
            this.cmbClaveCita.Name = "cmbClaveCita";
            this.cmbClaveCita.Size = new System.Drawing.Size(133, 21);
            this.cmbClaveCita.TabIndex = 14;
            this.cmbClaveCita.SelectedIndexChanged += new System.EventHandler(this.cmbClaveCita_SelectedIndexChanged);
            // 
            // lblEncabezado
            // 
            this.lblEncabezado.AutoSize = true;
            this.lblEncabezado.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblEncabezado.Location = new System.Drawing.Point(84, 60);
            this.lblEncabezado.Name = "lblEncabezado";
            this.lblEncabezado.Size = new System.Drawing.Size(222, 25);
            this.lblEncabezado.TabIndex = 15;
            this.lblEncabezado.Text = "CITAS INDIVIDUALES";
            // 
            // lblNombreMedico
            // 
            this.lblNombreMedico.AutoSize = true;
            this.lblNombreMedico.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblNombreMedico.Location = new System.Drawing.Point(28, 197);
            this.lblNombreMedico.Name = "lblNombreMedico";
            this.lblNombreMedico.Size = new System.Drawing.Size(115, 18);
            this.lblNombreMedico.TabIndex = 16;
            this.lblNombreMedico.Text = "Nombre medico";
            // 
            // txtNombreMedico
            // 
            this.txtNombreMedico.Enabled = false;
            this.txtNombreMedico.Location = new System.Drawing.Point(161, 194);
            this.txtNombreMedico.Name = "txtNombreMedico";
            this.txtNombreMedico.Size = new System.Drawing.Size(133, 20);
            this.txtNombreMedico.TabIndex = 17;
            // 
            // frmConsultaIndividualCitas
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(407, 488);
            this.Controls.Add(this.txtNombreMedico);
            this.Controls.Add(this.lblNombreMedico);
            this.Controls.Add(this.lblEncabezado);
            this.Controls.Add(this.cmbClaveCita);
            this.Controls.Add(this.txtObservaciones);
            this.Controls.Add(this.txtTelefonoPaciente);
            this.Controls.Add(this.txtNombrePaciente);
            this.Controls.Add(this.txtHora);
            this.Controls.Add(this.txtFecha);
            this.Controls.Add(this.txtClaveMedico);
            this.Controls.Add(this.lblObservaciones);
            this.Controls.Add(this.lblTelefonoPaciente);
            this.Controls.Add(this.lblNombrePaciente);
            this.Controls.Add(this.lblHora);
            this.Controls.Add(this.lblFecha);
            this.Controls.Add(this.lblClaveMedico);
            this.Controls.Add(this.lblClaveCita);
            this.Name = "frmConsultaIndividualCitas";
            this.Text = "Consulta Individual Citas";
            this.Load += new System.EventHandler(this.frmConsultaIndividualCitas_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblClaveCita;
        private System.Windows.Forms.Label lblClaveMedico;
        private System.Windows.Forms.Label lblFecha;
        private System.Windows.Forms.Label lblHora;
        private System.Windows.Forms.Label lblNombrePaciente;
        private System.Windows.Forms.Label lblTelefonoPaciente;
        private System.Windows.Forms.Label lblObservaciones;
        private System.Windows.Forms.TextBox txtClaveMedico;
        private System.Windows.Forms.TextBox txtFecha;
        private System.Windows.Forms.TextBox txtHora;
        private System.Windows.Forms.TextBox txtNombrePaciente;
        private System.Windows.Forms.TextBox txtTelefonoPaciente;
        private System.Windows.Forms.TextBox txtObservaciones;
        private System.Windows.Forms.ComboBox cmbClaveCita;
        private System.Windows.Forms.Label lblEncabezado;
        private System.Windows.Forms.Label lblNombreMedico;
        private System.Windows.Forms.TextBox txtNombreMedico;
    }
}