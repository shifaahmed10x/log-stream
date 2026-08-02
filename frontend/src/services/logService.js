import api from "./api";

export const searchLogs = async (request) => {
  const response = await api.post("/logs/search", request);
  return response.data;
};