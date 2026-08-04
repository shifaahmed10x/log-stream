import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Chip,
} from "@mui/material";

import GlassCard from "../cards/GlassCard";

function RecentLogsTable({ logs }) {
  return (
    <GlassCard sx={{ mt: 4 }}>

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
                key={log.id}
                hover
                sx={{
                  "&:hover": {
                    background: "rgba(139,92,246,.05)",
                  },
                }}
              >

                <TableCell>
                  {new Date(log.timestamp).toLocaleTimeString()}
                </TableCell>

                <TableCell>

                  <Chip
                    size="small"
                    label={log.logLevel}
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

                <TableCell>
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

    </GlassCard>
  );
}

export default RecentLogsTable;