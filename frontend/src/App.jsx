import Home from './pages/Home';
import Health from './pages/Health';
import Posts from './pages/Posts';
import CreatePost from './pages/CreatePost';
import { Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import PostDetail from './pages/PostDetail';

function App() {
 
  return (
    <>
    <Navbar />
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/health" element={<Health/>} />
      <Route path="/posts" element={<Posts />} />
      <Route path="/posts/new" element={<CreatePost />} />
      <Route path="/posts/:id" element={<PostDetail />} />
    </Routes>
    </>
  );
}
export default App
