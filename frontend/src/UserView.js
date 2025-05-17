import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

export default function UserView() {
  const { token } = useParams();
  const [info, setInfo] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    axios.get(`http://localhost:8080/user/public/view/${token}`)
      .then(res => setInfo(res.data))
      .catch(err => {
        console.error("Error fetching info:", err);
        setError("Failed to load certificate. Please check the link or try again later.");
      });
  }, [token]);

  if (error) {
    return <p style={{ color: "white", padding: "1rem" }}>{error}</p>;
  }

  if (!info) {
    return <p style={{ color: "white", padding: "1rem" }}>Loading...</p>;
  }

  return (
    <div style={{ backgroundColor: "#0057AB", fontFamily: "Arial, sans-serif", minHeight: "100vh", padding: "2rem" }}>
      <div className="certificate-container">
        <table>
          <tbody>
            <tr>
              <td style={{ width: "264px" }}>
                <img src="https://qrscan.kbzbank.co/img/kbzbank.png" alt="KBZ Bank Logo" style={{ maxWidth: "150px" }} />
              </td>
              <td style={{ width: "264px", textAlign: "right", verticalAlign: "bottom" }}>
                <span style={{ fontWeight: "bold", fontSize: "0.95rem" }}>
                  BALANCE CERTIFICATE
                </span>
              </td>
            </tr>
          </tbody>
        </table>

        <div style={{ borderTop: "2px solid #0000AB", marginTop: "-10px" }}>
          <div className="certificate-content">
            <h5 className="text-center" style={{ fontSize: "15.2px", fontWeight: 700, margin: "2rem 0 1rem" }}>
              DETAILS OF THE ISSUING CERTIFICATE
            </h5>

            {renderRow("Bank:", info.bank)}
            {renderRow("Account Holder Name:", info.name)}
            {renderRow("Account Number:", info.accountNumber)}
            {renderRow("Account Type:", info.accountType)}
            {renderRow("NRC/Passport No.:", info.passportNo)}
            {renderRow("Address:", info.address)}
            {renderRow("Issuing Branch:", info.branch)}
            {renderRow("Issuing Date:", info.issueDate)}
            {renderRow("Date of Balance:", info.balanceDate)}
            {renderRow("Balance in Figures:", info.balanceFigures)}
            {renderRow("Balance in Words:", info.balanceWords)}

            <hr />

            <div className="footer mt-3">
              <p>This Balance Certificate is valid until <strong>{info.validUntil}</strong>.</p>
              <div style={{ borderTop: "1px dashed #000", margin: "1rem 0" }} />
              <p>Thank you for banking with Kanbawza Bank Limited.</p>
              <p>No.615/1, Pyay Road, Kamayut Township, Yangon, Myanmar</p>
              <p>Call Center: <a href="tel:+959951018555">+95 9 951018555</a></p>
              <p>Email: <a href="mailto:customer_service@kbzbank.com">customer_service@kbzbank.com</a></p>
              <p>This is a secure verification web portal provided by KBZ Bank.</p>
              <p>If you suspect fraud or tampering, please contact us immediately.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

function renderRow(label, value) {
  return (
    <>
      <div className="row mb-3" style={{ display: "flex", justifyContent: "space-between", fontSize: "13.6px" }}>
        <div>{label}</div>
        <div style={{ fontWeight: "bold", textAlign: "right" }}>{value}</div>
      </div>
      <hr />
    </>
  );
}
