import Topbar from './components/topbar/Topbar';
import './App.css';
import {
  BrowserRouter as Router,
  Route,
  Routes
} from "react-router-dom";
import PriceCalculator from './pages/PriceCalculator/PriceCalculator.jsx'
import PriceCatelog from './pages/PriceCatelog/PriceCatelog';
function App() {
  return (
    <Router>
            <Topbar />
            <div className="container">
              <Routes>
                <Route exact path="/" element={<PriceCatelog />}></Route>
                <Route path="/calculator" element={<PriceCalculator />}></Route>
              </Routes>
            </div>
          </Router>
  );
}

export default App;
