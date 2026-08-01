import {
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
} from "@mui/material";

const rows = [
  {
    time: "10:45:12",
    level: "INFO",
    service: "Auth Service",
    message: "User login successful",
  },
  {
    time: "10:46:21",
    level: "ERROR",
    service: "API Gateway",
    message: "500 Internal Server Error",
  },
  {
    time: "10:47:55",
    level: "WARNING",
    service: "Payment",
    message: "Slow response detected",
  },
];

function RecentLogsTable() {
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
          {rows.map((row, index) => (
            <TableRow key={index}>
              <TableCell sx={{ color: "#D1D5DB" }}>{row.time}</TableCell>
              <TableCell sx={{ color: "#D1D5DB" }}>{row.level}</TableCell>
              <TableCell sx={{ color: "#D1D5DB" }}>{row.service}</TableCell>
              <TableCell sx={{ color: "#D1D5DB" }}>{row.message}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default RecentLogsTable;