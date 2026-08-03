import { useEffect, useState } from "react";

import {
  connectWebSocket,
  disconnectWebSocket,
} from "../services/websocketService";

function LiveTail() {

  const [logs, setLogs] = useState([]);

  useEffect(() => {

    connectWebSocket((newLog) => {

      setLogs((previous) => [newLog, ...previous]);

    });

    return () => disconnectWebSocket();

  }, []);

  return (

    <div style={{ padding: 20 }}>

      <h1>Live Tail</h1>

      <table
        style={{
          width: "100%",
          borderCollapse: "collapse",
        }}
      >

        <thead>

          <tr>

            <th>Time</th>
            <th>Level</th>
            <th>Application</th>
            <th>Service</th>
            <th>Message</th>

          </tr>

        </thead>

        <tbody>

          {logs.map((log) => (

            <tr key={log.id}>

              <td>{log.timestamp}</td>
              <td>{log.logLevel}</td>
              <td>{log.applicationName}</td>
              <td>{log.serviceName}</td>
              <td>{log.message}</td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>

  );

}

export default LiveTail;