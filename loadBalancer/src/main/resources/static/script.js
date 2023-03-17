const form = document.querySelector('form');
const resultado = document.querySelector('#resultado');

form.addEventListener('submit', async (e) => {
    e.preventDefault();
    const texto = document.querySelector('#texto').value;

    try {
        // Enviar la solicitud POST
        const respuestaPost = await fetch('http://localhost:8080/post', {
            method: 'POST',
            body: texto,
            headers: {
                'Content-Type': 'text/plain'
            }
        });

        // Cargar y mostrar la solicitud GET
        const respuestaGet = await fetch('http://localhost:8080/get');
        const datosGet = await respuestaGet.json();
        resultado.innerHTML += `<p>Respuesta GET:</p><pre>${JSON.stringify(datosGet, null, 2)}</pre>`;

    } catch (error) {
        console.error(error);
        resultado.innerHTML = `Error: ${error}`;
    }
});
