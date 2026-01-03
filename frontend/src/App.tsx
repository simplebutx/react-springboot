import { useEffect, useState } from 'react'
import './App.css'

function App() {
 const [msg, setMsg] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/api/health")
      .then(res => res.text())
      .then(data => setMsg(data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div>
      <h1>React ↔ Spring Test</h1>
      <p>{msg}</p>
    </div>
  );
}
export default App
