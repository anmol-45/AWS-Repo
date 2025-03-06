exports.handler = async (event) => {
    const httpMethod = event.httpMethod;
    const path = event.path;

    const response = {
        statusCode: 200,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ message: 'Hello from Lambda!' }) // Default message
    };

    if (path !== '/hello' || httpMethod !== 'GET') {
        // If not, return 400 with an error message
        response.statusCode = 400;
        response.body = JSON.stringify({ error: 'Invalid request' });
    }

    return response;
};
