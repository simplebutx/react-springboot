import './App.css'
import Home from './pages/Home';
import Health from './pages/Health';
import Posts from './pages/Posts';
import { Routes, Route } from 'react-router-dom';

function App() {
 
  return (
    <>
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/health" element={<Health/>} />
      <Route path="/posts" element={<Posts />} />
    </Routes>
    </>
  );
}
export default App
