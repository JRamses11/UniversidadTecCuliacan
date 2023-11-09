namespace Alumnos_CarrerasGUI
{
    partial class frmAlumnos
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.lblNControl = new System.Windows.Forms.Label();
            this.lblNombre = new System.Windows.Forms.Label();
            this.lblDomicilio = new System.Windows.Forms.Label();
            this.lblEdad = new System.Windows.Forms.Label();
            this.lblCarrera = new System.Windows.Forms.Label();
            this.txtNControl = new System.Windows.Forms.TextBox();
            this.txtNombre = new System.Windows.Forms.TextBox();
            this.txtDomicilio = new System.Windows.Forms.TextBox();
            this.numEdad = new System.Windows.Forms.NumericUpDown();
            this.btnGuardar = new System.Windows.Forms.Button();
            this.btnLimpiar = new System.Windows.Forms.Button();
            this.btnConsultar = new System.Windows.Forms.Button();
            this.grbSexo = new System.Windows.Forms.GroupBox();
            this.rbMasculino = new System.Windows.Forms.RadioButton();
            this.rbFemenino = new System.Windows.Forms.RadioButton();
            this.cmbCarrera = new System.Windows.Forms.ComboBox();
            this.btnAgregarCarrera = new System.Windows.Forms.Button();
            this.errP1 = new System.Windows.Forms.ErrorProvider(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.numEdad)).BeginInit();
            this.grbSexo.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errP1)).BeginInit();
            this.SuspendLayout();
            // 
            // lblNControl
            // 
            this.lblNControl.AutoSize = true;
            this.lblNControl.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblNControl.Location = new System.Drawing.Point(40, 61);
            this.lblNControl.Name = "lblNControl";
            this.lblNControl.Size = new System.Drawing.Size(60, 16);
            this.lblNControl.TabIndex = 0;
            this.lblNControl.Text = "NControl";
            // 
            // lblNombre
            // 
            this.lblNombre.AutoSize = true;
            this.lblNombre.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblNombre.Location = new System.Drawing.Point(43, 106);
            this.lblNombre.Name = "lblNombre";
            this.lblNombre.Size = new System.Drawing.Size(57, 16);
            this.lblNombre.TabIndex = 1;
            this.lblNombre.Text = "Nombre";
            // 
            // lblDomicilio
            // 
            this.lblDomicilio.AutoSize = true;
            this.lblDomicilio.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblDomicilio.Location = new System.Drawing.Point(40, 147);
            this.lblDomicilio.Name = "lblDomicilio";
            this.lblDomicilio.Size = new System.Drawing.Size(64, 16);
            this.lblDomicilio.TabIndex = 2;
            this.lblDomicilio.Text = "Domicilio";
            // 
            // lblEdad
            // 
            this.lblEdad.AutoSize = true;
            this.lblEdad.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblEdad.Location = new System.Drawing.Point(51, 203);
            this.lblEdad.Name = "lblEdad";
            this.lblEdad.Size = new System.Drawing.Size(41, 16);
            this.lblEdad.TabIndex = 3;
            this.lblEdad.Text = "Edad";
            // 
            // lblCarrera
            // 
            this.lblCarrera.AutoSize = true;
            this.lblCarrera.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblCarrera.Location = new System.Drawing.Point(382, 38);
            this.lblCarrera.Name = "lblCarrera";
            this.lblCarrera.Size = new System.Drawing.Size(53, 16);
            this.lblCarrera.TabIndex = 4;
            this.lblCarrera.Text = "Carrera";
            // 
            // txtNControl
            // 
            this.txtNControl.Enabled = false;
            this.txtNControl.Location = new System.Drawing.Point(111, 57);
            this.txtNControl.Name = "txtNControl";
            this.txtNControl.ReadOnly = true;
            this.txtNControl.Size = new System.Drawing.Size(133, 20);
            this.txtNControl.TabIndex = 5;
            // 
            // txtNombre
            // 
            this.txtNombre.CharacterCasing = System.Windows.Forms.CharacterCasing.Upper;
            this.txtNombre.Location = new System.Drawing.Point(111, 102);
            this.txtNombre.Name = "txtNombre";
            this.txtNombre.Size = new System.Drawing.Size(369, 20);
            this.txtNombre.TabIndex = 6;
            this.txtNombre.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtNombre_KeyPress);
            this.txtNombre.Validated += new System.EventHandler(this.txtNombre_Validated);
            // 
            // txtDomicilio
            // 
            this.txtDomicilio.CharacterCasing = System.Windows.Forms.CharacterCasing.Upper;
            this.txtDomicilio.Location = new System.Drawing.Point(111, 146);
            this.txtDomicilio.Name = "txtDomicilio";
            this.txtDomicilio.Size = new System.Drawing.Size(369, 20);
            this.txtDomicilio.TabIndex = 7;
            this.txtDomicilio.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtDomicilio_KeyPress);
            this.txtDomicilio.Validated += new System.EventHandler(this.txtDomicilio_Validated);
            // 
            // numEdad
            // 
            this.numEdad.Location = new System.Drawing.Point(111, 203);
            this.numEdad.Minimum = new decimal(new int[] {
            16,
            0,
            0,
            0});
            this.numEdad.Name = "numEdad";
            this.numEdad.Size = new System.Drawing.Size(53, 20);
            this.numEdad.TabIndex = 8;
            this.numEdad.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.numEdad.Value = new decimal(new int[] {
            16,
            0,
            0,
            0});
            // 
            // btnGuardar
            // 
            this.btnGuardar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnGuardar.Location = new System.Drawing.Point(111, 283);
            this.btnGuardar.Name = "btnGuardar";
            this.btnGuardar.Size = new System.Drawing.Size(110, 36);
            this.btnGuardar.TabIndex = 10;
            this.btnGuardar.Text = "Guardar";
            this.btnGuardar.UseVisualStyleBackColor = true;
            this.btnGuardar.Click += new System.EventHandler(this.btnGuardar_Click);
            // 
            // btnLimpiar
            // 
            this.btnLimpiar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnLimpiar.Location = new System.Drawing.Point(274, 283);
            this.btnLimpiar.Name = "btnLimpiar";
            this.btnLimpiar.Size = new System.Drawing.Size(110, 36);
            this.btnLimpiar.TabIndex = 11;
            this.btnLimpiar.Text = "Limpiar";
            this.btnLimpiar.UseVisualStyleBackColor = true;
            this.btnLimpiar.Click += new System.EventHandler(this.btnLimpiar_Click);
            // 
            // btnConsultar
            // 
            this.btnConsultar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnConsultar.Location = new System.Drawing.Point(428, 283);
            this.btnConsultar.Name = "btnConsultar";
            this.btnConsultar.Size = new System.Drawing.Size(110, 36);
            this.btnConsultar.TabIndex = 12;
            this.btnConsultar.Text = "Consultar";
            this.btnConsultar.UseVisualStyleBackColor = true;
            this.btnConsultar.Click += new System.EventHandler(this.btnConsultar_Click);
            // 
            // grbSexo
            // 
            this.grbSexo.Controls.Add(this.rbMasculino);
            this.grbSexo.Controls.Add(this.rbFemenino);
            this.grbSexo.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.grbSexo.Location = new System.Drawing.Point(520, 71);
            this.grbSexo.Name = "grbSexo";
            this.grbSexo.Size = new System.Drawing.Size(154, 95);
            this.grbSexo.TabIndex = 13;
            this.grbSexo.TabStop = false;
            this.grbSexo.Text = "Sexo";
            // 
            // rbMasculino
            // 
            this.rbMasculino.AutoSize = true;
            this.rbMasculino.Location = new System.Drawing.Point(7, 64);
            this.rbMasculino.Name = "rbMasculino";
            this.rbMasculino.Size = new System.Drawing.Size(87, 20);
            this.rbMasculino.TabIndex = 1;
            this.rbMasculino.Text = "Masculino";
            this.rbMasculino.UseVisualStyleBackColor = true;
            // 
            // rbFemenino
            // 
            this.rbFemenino.AutoSize = true;
            this.rbFemenino.Checked = true;
            this.rbFemenino.Location = new System.Drawing.Point(6, 28);
            this.rbFemenino.Name = "rbFemenino";
            this.rbFemenino.Size = new System.Drawing.Size(86, 20);
            this.rbFemenino.TabIndex = 0;
            this.rbFemenino.TabStop = true;
            this.rbFemenino.Text = "Femenino";
            this.rbFemenino.UseVisualStyleBackColor = true;
            // 
            // cmbCarrera
            // 
            this.cmbCarrera.FormattingEnabled = true;
            this.cmbCarrera.Location = new System.Drawing.Point(347, 57);
            this.cmbCarrera.Name = "cmbCarrera";
            this.cmbCarrera.Size = new System.Drawing.Size(121, 21);
            this.cmbCarrera.TabIndex = 14;
            // 
            // btnAgregarCarrera
            // 
            this.btnAgregarCarrera.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.btnAgregarCarrera.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnAgregarCarrera.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.btnAgregarCarrera.Location = new System.Drawing.Point(520, 203);
            this.btnAgregarCarrera.Name = "btnAgregarCarrera";
            this.btnAgregarCarrera.Size = new System.Drawing.Size(154, 54);
            this.btnAgregarCarrera.TabIndex = 15;
            this.btnAgregarCarrera.Text = "Agregar Carrera";
            this.btnAgregarCarrera.UseVisualStyleBackColor = false;
            this.btnAgregarCarrera.Click += new System.EventHandler(this.btnAgregarCarrera_Click);
            // 
            // errP1
            // 
            this.errP1.ContainerControl = this;
            // 
            // frmAlumnos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(703, 366);
            this.Controls.Add(this.btnAgregarCarrera);
            this.Controls.Add(this.cmbCarrera);
            this.Controls.Add(this.grbSexo);
            this.Controls.Add(this.btnConsultar);
            this.Controls.Add(this.btnLimpiar);
            this.Controls.Add(this.btnGuardar);
            this.Controls.Add(this.numEdad);
            this.Controls.Add(this.txtDomicilio);
            this.Controls.Add(this.txtNombre);
            this.Controls.Add(this.txtNControl);
            this.Controls.Add(this.lblCarrera);
            this.Controls.Add(this.lblEdad);
            this.Controls.Add(this.lblDomicilio);
            this.Controls.Add(this.lblNombre);
            this.Controls.Add(this.lblNControl);
            this.Name = "frmAlumnos";
            this.Text = "Captura de Alumnos";
            this.Load += new System.EventHandler(this.frmAlumnos_Load);
            ((System.ComponentModel.ISupportInitialize)(this.numEdad)).EndInit();
            this.grbSexo.ResumeLayout(false);
            this.grbSexo.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errP1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblNControl;
        private System.Windows.Forms.Label lblNombre;
        private System.Windows.Forms.Label lblDomicilio;
        private System.Windows.Forms.Label lblEdad;
        private System.Windows.Forms.Label lblCarrera;
        private System.Windows.Forms.TextBox txtNControl;
        private System.Windows.Forms.TextBox txtNombre;
        private System.Windows.Forms.TextBox txtDomicilio;
        private System.Windows.Forms.NumericUpDown numEdad;
        private System.Windows.Forms.Button btnGuardar;
        private System.Windows.Forms.Button btnLimpiar;
        private System.Windows.Forms.Button btnConsultar;
        private System.Windows.Forms.GroupBox grbSexo;
        private System.Windows.Forms.RadioButton rbMasculino;
        private System.Windows.Forms.RadioButton rbFemenino;
        private System.Windows.Forms.ComboBox cmbCarrera;
        private System.Windows.Forms.Button btnAgregarCarrera;
        private System.Windows.Forms.ErrorProvider errP1;
    }
}

