# chat
REST API Chat Server

<p>The server expose one endpoint: </p>
<b>POST /messages/{type} </b>

<p>Server support only 2 types of messages:</p>

<p>•  send_text (e.g. http://localhost/messages/send_text) </p>
<p>•  send_emotion (e.g. http://localhost/messages/send_emotion) </p>
<p>This endpoint expect one mandatory parameter with name payload, which should not be passed in the URL. In case of send_text the payload length should be between 1 and 160 In case of send_emotion the payload should be between 2 and 10 and should not contain characters between 0 and 9    In case the preconditions are not met the server should respond with status code 412 and empty body. In case the preconditions are met the server should respond with status code 201 and empty body.   