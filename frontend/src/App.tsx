import Home from './pages/Home';
import Health from './pages/Health';
import Posts from './pages/Posts';
import CreatePost from './pages/CreatePost';
import { Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';

function App() {
 
  return (
    <>
    <Navbar />
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/health" element={<Health/>} />
      <Route path="/posts" element={<Posts />} />
      <Route path="/posts/new" element={<CreatePost />} />
    </Routes>
    </>
  );
}
export default App
