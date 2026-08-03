import { BrowserRouter, Routes, Route } from "react-router-dom";

import Dashboard from "../pages/Dashboard";
import SearchLogs from "../pages/SearchLogs";
import Analytics from "../pages/Analytics";
import LiveTail from "../pages/LiveTail";
import MainLayout from "../layouts/MainLayout";

function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<MainLayout />}>
          <Route index element={<Dashboard />} />
          <Route path="search" element={<SearchLogs />} />
          <Route path="analytics" element={<Analytics />} />
          <Route path="live-tail" element={<LiveTail />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default AppRoutes;