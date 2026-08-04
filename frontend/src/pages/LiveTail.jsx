import { useEffect, useState } from "react";

import {
  Box,
  Typography,
  Chip,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
} from "@mui/material";

import GlassCard from "../components/cards/GlassCard";

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
  <Box>

    <Typography
      variant="h3"
      fontWeight={700}
      mb={1}
    >
      Live Stream
    </Typography>

    <Box
      display="flex"
      alignItems="center"
      gap={1}
      mb={3}
    >
      <Box
        sx={{
          width: 10,
          height: 10,
          borderRadius: "50%",
          bgcolor: "#22C55E",
          boxShadow: "0 0 12px #22C55E",
        }}
      />

      <Typography color="success.main">
        Connected • Listening for incoming logs
      </Typography>
    </Box>

    <GlassCard>

      {logs.length === 0 ? (

        <Box
          py={8}
          textAlign="center"
        >
          <Typography
            variant="h6"
            color="text.secondary"
          >
            Waiting for incoming logs...
          </Typography>

          <Typography color="text.secondary">
            New logs will appear automatically.
          </Typography>
        </Box>

      ) : (

        <TableContainer>

          <Table>

            <TableHead>

              <TableRow
                sx={{
                  background: "rgba(255,255,255,.03)",
                }}
              >
                <TableCell sx={{ fontWeight: 700 }}>
                  Time
                </TableCell>

                <TableCell sx={{ fontWeight: 700 }}>
                  Level
                </TableCell>

                <TableCell sx={{ fontWeight: 700 }}>
                  Application
                </TableCell>

                <TableCell sx={{ fontWeight: 700 }}>
                  Service
                </TableCell>

                <TableCell sx={{ fontWeight: 700 }}>
                  Message
                </TableCell>
              </TableRow>

            </TableHead>

            <TableBody>

              {logs.map((log) => (

                <TableRow
                  hover
                  key={log.id}
                  sx={{
                    "&:hover": {
                      background:
                        "rgba(139,92,246,.05)",
                    },
                  }}
                >

                  <TableCell width={180}>
                    {new Date(log.timestamp).toLocaleString()}
                  </TableCell>

                  <TableCell width={120}>

                    <Chip
                      label={log.logLevel}
                      size="small"
                      color={
                        log.logLevel === "ERROR"
                          ? "error"
                          : log.logLevel === "WARN"
                          ? "warning"
                          : log.logLevel === "INFO"
                          ? "success"
                          : log.logLevel === "DEBUG"
                          ? "primary"
                          : "default"
                      }
                    />

                  </TableCell>

                  <TableCell width={180}>
                    {log.applicationName}
                  </TableCell>

                  <TableCell width={180}>
                    {log.serviceName}
                  </TableCell>

                  <TableCell>
                    {log.message}
                  </TableCell>

                </TableRow>

              ))}

            </TableBody>

          </Table>

        </TableContainer>

      )}

    </GlassCard>

  </Box>
);
}

export default LiveTail;