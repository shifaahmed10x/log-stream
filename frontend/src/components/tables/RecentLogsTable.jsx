import {
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
} from "@mui/material";

function RecentLogsTable({ logs }) {
  console.log(logs);

  return (
    <TableContainer component={Paper} sx={{ mt: 4, bgcolor: "#111827" }}>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell sx={{ color: "white" }}>Time</TableCell>
            <TableCell sx={{ color: "white" }}>Level</TableCell>
            <TableCell sx={{ color: "white" }}>Service</TableCell>
            <TableCell sx={{ color: "white" }}>Message</TableCell>
          </TableRow>
        </TableHead>

        <TableBody>
          {logs.map((log) => (
            <TableRow key={log.id}>
              <TableCell sx={{ color: "#D1D5DB" }}>
                {new Date(log.timestamp).toLocaleTimeString()}
              </TableCell>

              <TableCell sx={{ color: "#D1D5DB" }}>
                {log.logLevel}
              </TableCell>

              <TableCell sx={{ color: "#D1D5DB" }}>
                {log.serviceName}
              </TableCell>

              <TableCell sx={{ color: "#D1D5DB" }}>
                {log.message}
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default RecentLogsTable;