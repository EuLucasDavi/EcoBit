class FormSubmit {
  constructor(settings) {
      this.settings = settings;
      this.form = document.querySelector(settings.form);
      this.formButton = document.querySelector(settings.button);
      this.isSubmitting = false;

      if (this.form) {
          this.url = this.form.getAttribute("action");
      }

      this.sendForm = this.sendForm.bind(this);
  }

  getFormObject() {
      const formObject = {};
      const fields = this.form.querySelectorAll("[name]");
      fields.forEach((field) => {
          formObject[field.getAttribute("name")] = field.value;
      });
      return formObject;
  }

  async sendForm(event) {
      try {
          event.preventDefault(); // Impede o comportamento padrão do formulário

          // Desativa o botão e altera o texto apenas no início do envio
          this.formButton.disabled = true;
          this.formButton.innerText = "Enviando...";

          const response = await fetch(this.url, {
              method: "POST",
              headers: {
                  "Content-Type": "application/json",
                  Accept: "application/json",
              },
              body: JSON.stringify(this.getFormObject()),
          });

          if (response.ok) {
              this.displaySuccess();
          } else {
              this.displayErrorModal();
          }
      } catch (error) {
          this.displayError();
          throw new Error(error);
      } finally {
          // Restaurar o estado original do botão após a conclusão da requisição
          this.formButton.disabled = false;
          this.formButton.innerText = "Enviar";

          // Resetar a flag após a conclusão do envio
          this.isSubmitting = false;
      }
  }

  displaySuccess() {
      $("#portfolioModal8").modal("show");
  }

  displayErrorModal() {
      $("#portfolioModal9").modal("show");
  }

  init() {
      if (this.form) this.form.addEventListener("submit", this.sendForm);
      return this;
  }
}

document.addEventListener("DOMContentLoaded", function () {
  const formSubmit = new FormSubmit({
      form: "#contactForm",
      button: "#submitButton",
  });

  formSubmit.init();
});