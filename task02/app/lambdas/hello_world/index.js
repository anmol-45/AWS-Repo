exports.handler = async (event) => {
    const httpMethod = event.httpMethod;
    const path = event.path;

    const response = {
        statusCode: 200,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ message: 'Hello from Lambda!' })
    };

    if (path === '/hello' && httpMethod === 'GET') {
        response.body = JSON.stringify({ message: 'Hello from Lambda!' });
    } else {
        response.statusCode = 400;
        response.body = JSON.stringify({ error: 'Invalid request' });
    }

    return response;
};
