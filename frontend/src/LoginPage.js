import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function LoginPage() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = () => {
    // Simple auth check (replace with real validation)
    if (username === 'admin' && password === 'admin') {
      navigate('/admin');
    } else {
      alert('Invalid credentials');
    }
  };

  return (
    <div className="min-h-screen bg-white">
      {/* Header */}
      <div className="h-20 bg-white"></div>

      {/* Main Body with Glassmorphism Card */}
      <div className="bg-blue-800 min-h-[calc(100vh-6rem)] flex items-center justify-center">
        <div className="bg-white bg-opacity-10 backdrop-blur-md p-10 rounded-2xl shadow-xl w-full max-w-md text-white">
          <h2 className="text-2xl font-bold mb-6 text-center">Login</h2>

          <input
            type="text"
            placeholder="Username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            className="w-full px-4 py-2 mb-4 rounded-lg bg-white bg-opacity-20 focus:outline-none focus:ring-2 focus:ring-blue-300 placeholder-white"
          />

          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            className="w-full px-4 py-2 mb-6 rounded-lg bg-white bg-opacity-20 focus:outline-none focus:ring-2 focus:ring-blue-300 placeholder-white"
          />

          <div className="flex justify-center">
          <button
            onClick={handleLogin}
            className="w-24 bg-white text-blue-800 py-2 rounded-lg font-semibold hover:bg-blue-100 transition duration-300"
          >
            Login
          </button>
        </div>
        </div>
      </div>
    </div>
  );
}