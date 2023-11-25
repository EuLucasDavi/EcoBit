var errorShown = false
 
function checkCNPJ(cnpj) {
    $.ajax({
        'url': `https://receitaws.com.br/v1/cnpj/` + cnpj.replace(/[^0-9]/g, ''),
        'type': "GET",
        'dataType': "jsonp",
        'success': function (data) {
            if (data.nome === undefined) {
                if (!errorShown) {
                
                    $('#portfolioModal5').modal('show');
                    errorShown = true; // Define a variável para indicar que o erro foi exibido
                    errorShown = false;
                    document.getElementById('logradourojs').value = '';
                    document.getElementById('numero').value = '';
                    document.getElementById('nomejs').value = '';
    
                }
            } else {
                document.getElementById('logradourojs').value = data.logradouro +", " + data.bairro;
                document.getElementById('numerojs').value = data.numero;
                document.getElementById('nomejs').value = data.nome
                
            }
        },
        'error': function () {
            if (!errorShown) {
                $('#portfolioModal5').modal('show');
                errorShown = true;
                errorShown = false;
            }
        }
    });
}

window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar 
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    //  Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            rootMargin: '0px 0px -40%',
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

});

// Mascara cnpj
$(document).ready(function () {
    $('#company_cnpj').mask('00.000.000/0000-00');
});

// Máscara de horário no input
function mascaraHora() {
    let horarios = document.querySelectorAll('.input-hora');
    horarios.forEach(hora => {
        hora.addEventListener('input', function (e) {
            let value = this.value;
            if (value.length == 2) {
                this.value = value + ':';
            }
        });
    });
}

// Inicializando a função
// Mascara cnpj
$(document).ready(function () {
    $('#company_cnpj').mask('00.000.000/0000-00');
});

// Máscara de horário no input
function mascaraHora() {
    let horarios = document.querySelectorAll('.input-hora');
    horarios.forEach(hora => {
        hora.addEventListener('input', function (e) {
            let value = this.value;
            if (value.length == 2) {
                this.value = value + ':';
            }
        });
    });
}

// Inicializando a função
mascaraHora();

// Enviar dados do formulário #local
$(document).ready(function () {
    $('#local').on('submit', function (e) {
        e.preventDefault(); // Impede o comportamento padrão do envio do formulário

        // Aqui você pode adicionar a lógica para enviar os dados para o servidor via AJAX
        $.ajax({
            type: "POST",
            url: "/savePonto",
            data: $(this).serialize(),
            success: function () {
                // Exibe o modal de sucesso
                $('#portfolioModal4').modal('show');
            },
            error: function () {
                // Exibe o modal de erro
                $('#portfolioModal5').modal('show');
            }
        });
    });
});

// Enviar dados do formulário #company
$(document).ready(function () {
    $('#company').on('submit', function (e) {
        e.preventDefault(); // Impede o comportamento padrão do envio do formulário

        // Aqui você pode adicionar a lógica para enviar os dados para o servidor via AJAX
        $.ajax({
            type: "POST",
            url: "/save",
            data: $(this).serialize(),
            success: function () {
                // Exibe o modal de sucesso
                $('#portfolioModal4').modal('show');
            },
            error: function () {
                // Exibe o modal de erro
                $('#portfolioModal5').modal('show');
            }
        });
    });
});
