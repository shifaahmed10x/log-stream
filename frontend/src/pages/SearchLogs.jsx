import { useState } from "react";
import {
  Typography,
  Box,
  TextField,
  MenuItem,
  Button,
} from "@mui/material";

import RecentLogsTable from "../components/tables/RecentLogsTable";
import { searchLogs } from "../services/logService";

function SearchLogs() {
  const [keyword, setKeyword] = useState("");
  const [logLevel, setLogLevel] = useState("");
  const [logs, setLogs] = useState([]);

  const handleSearch = async () => {
    try {
      const response = await searchLogs({
        keyword,
        applicationName: "",
        serviceName: "",
        hostName: "",
        logLevel,
        loggerName: "",
        threadName: "",
        startDate: null,
        endDate: null,
        page: 0,
        pageSize: 10,
        sortBy: "timestamp",
        sortDirection: "desc",
      });

      setLogs(response.logs);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <>
      <Typography variant="h3" color="white" mb={4}>
        Search Logs
      </Typography>

      <Box
        sx={{
          display: "flex",
          gap: 2,
          mb: 4,
          flexWrap: "wrap",
        }}
      >
        <TextField
          label="Keyword"
          value={keyword}
          onChange={(e) => setKeyword(e.target.value)}
        />

        <TextField
          select
          label="Log Level"
          value={logLevel}
          onChange={(e) => setLogLevel(e.target.value)}
          sx={{ width: 180 }}
        >
          <MenuItem value="">All</MenuItem>
          <MenuItem value="INFO">INFO</MenuItem>
          <MenuItem value="WARN">WARN</MenuItem>
          <MenuItem value="ERROR">ERROR</MenuItem>
        </TextField>

        <Button
          variant="contained"
          onClick={handleSearch}
        >
          Search
        </Button>
      </Box>

      <RecentLogsTable logs={logs} />
    </>
  );
}

export default SearchLogs;