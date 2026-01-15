import { useEffect, useState } from 'react'

function Health() {
  const [msg, setMsg] = useState("");

  useEffect(()=>{
    const fetchHealth = async () => {
      try {
        const res = await fetch("http://localhost:8080/api/health");
        const data = await res.text();
        setMsg(data)
      } catch(error) {
        console.log(error)
      }
    };
    
    fetchHealth();
  }, [])

    return(
    <div>
      <h3>React ↔ Spring 연결테스트</h3>
      <p>{msg}</p>
    </div>
    )
}

export default Health;