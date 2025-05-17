import React from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import UserView from './UserView';
import LoginPage from './LoginPage'; // Assuming you created this file earlier
import AdminPanel from './AdminPanel'; // Make sure this exists
import SuccessPage from './SuccessPage';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Navigate to="/login" />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/admin" element={<AdminPanel />} />
        <Route path="/user" element={<UserView />} />
        <Route path="/success" element={<SuccessPage />} />
        <Route path="/user/public/view/:token" element={<UserView />} />
      </Routes>
    </Router>
  );
}

export default App;
