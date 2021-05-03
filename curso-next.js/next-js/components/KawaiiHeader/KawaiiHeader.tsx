import React from 'react'
import { Confirm } from 'semantic-ui-react'

import PuesVivo from './AnimatedHeader'
import PuesMuero from './RottenHeader'
import ModalHeaderContent from './ModalHeaderContent'

const KawaiiHeader = () => {
  const [visible, setVisible] = React.useState(true)
  const [meMori, setMeMori] = React.useState(false)
  const [modalOpen, setModalOpen] = React.useState(false)
  const [count, setCount] = React.useState(0)

  const closeModal = () => setModalOpen(false)
  const toggleVisible = () => setVisible((prevVisible) => !prevVisible)

  React.useEffect(() => {
    window.setTimeout(toggleVisible, 350)
  }, [])

  React.useEffect(() => {
    if (count === 4) {
      setMeMori(true)
      setModalOpen(true)
    }
  }, [count])

  return (
    <div className="container">
      {meMori ? (
        <PuesMuero />
      ) : (
        <PuesVivo
          visible={visible}
          onClick={toggleVisible}
          onComplete={() => setCount((prevCount) => prevCount + 1)}
        />
      )}

      <Confirm
        open={modalOpen}
        content={ModalHeaderContent}
        onCancel={closeModal}
        onConfirm={closeModal}
        cancelButton="Ay, lo siento"
        confirmButton="OK"
        closeOnDimmerClick={false}
      />

      <style jsx>
        {`
          .container {
            margin: 2rem 0;
          }
          .container :global(.header) {
            display: flex;
            align-items: center;
            justify-content: center;
          }
        `}
      </style>
    </div>
  )
}

export default KawaiiHeader
