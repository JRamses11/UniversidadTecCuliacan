
namespace EncuestaGUI
{
    partial class frmPrincipal
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
            this.cmbSeleccion = new System.Windows.Forms.ComboBox();
            this.lblTitulo = new System.Windows.Forms.Label();
            this.btnVotar = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.btnFinalizar = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // cmbSeleccion
            // 
            this.cmbSeleccion.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cmbSeleccion.FormattingEnabled = true;
            this.cmbSeleccion.Items.AddRange(new object[] {
            "Cruz azul",
            "Chivas",
            "Pumas",
            "America",
            "Monterrey",
            "Tigres",
            "Pachuca",
            "Santos"});
            this.cmbSeleccion.Location = new System.Drawing.Point(156, 119);
            this.cmbSeleccion.Name = "cmbSeleccion";
            this.cmbSeleccion.Size = new System.Drawing.Size(133, 23);
            this.cmbSeleccion.TabIndex = 0;
            this.cmbSeleccion.Text = "Selecciona";
            this.cmbSeleccion.SelectedIndexChanged += new System.EventHandler(this.cmbSeleccion_SelectedIndexChanged);
            // 
            // lblTitulo
            // 
            this.lblTitulo.AutoSize = true;
            this.lblTitulo.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblTitulo.Location = new System.Drawing.Point(80, 31);
            this.lblTitulo.Name = "lblTitulo";
            this.lblTitulo.Size = new System.Drawing.Size(294, 29);
            this.lblTitulo.TabIndex = 1;
            this.lblTitulo.Text = "ENCUESTA FUTBOLERA";
            // 
            // btnVotar
            // 
            this.btnVotar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnVotar.Location = new System.Drawing.Point(119, 263);
            this.btnVotar.Name = "btnVotar";
            this.btnVotar.Size = new System.Drawing.Size(81, 29);
            this.btnVotar.TabIndex = 2;
            this.btnVotar.Text = "Votar";
            this.btnVotar.UseVisualStyleBackColor = true;
            this.btnVotar.Click += new System.EventHandler(this.btnVotar_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(107, 89);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(229, 16);
            this.label1.TabIndex = 3;
            this.label1.Text = "Vota por tu equipo favorito de Mexico";
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::EncuestaGUI.Properties.Resources.unnamed;
            this.pictureBox1.Location = new System.Drawing.Point(2, 298);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(446, 204);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 4;
            this.pictureBox1.TabStop = false;
            // 
            // btnFinalizar
            // 
            this.btnFinalizar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnFinalizar.Location = new System.Drawing.Point(245, 263);
            this.btnFinalizar.Name = "btnFinalizar";
            this.btnFinalizar.Size = new System.Drawing.Size(91, 29);
            this.btnFinalizar.TabIndex = 5;
            this.btnFinalizar.Text = "Finalizar";
            this.btnFinalizar.UseVisualStyleBackColor = true;
            this.btnFinalizar.Click += new System.EventHandler(this.btnFinalizar_Click);
            // 
            // frmPrincipal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(465, 514);
            this.Controls.Add(this.btnFinalizar);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnVotar);
            this.Controls.Add(this.lblTitulo);
            this.Controls.Add(this.cmbSeleccion);
            this.Name = "frmPrincipal";
            this.Text = "Cartilla";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox cmbSeleccion;
        private System.Windows.Forms.Label lblTitulo;
        private System.Windows.Forms.Button btnVotar;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Button btnFinalizar;
    }
}

