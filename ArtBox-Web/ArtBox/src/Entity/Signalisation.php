<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Signalisation
 *
 * @ORM\Table(name="signalisation", indexes={@ORM\Index(name="fkkk", columns={"id_post"}), @ORM\Index(name="fuuaz", columns={"id_user"})})
 * @ORM\Entity(repositoryClass="App\Repository\SignalisationRepository")
 */
class Signalisation
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_signal", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idSignal;

    /**
     * @var string
     *
     * @ORM\Column(name="contenu_signal", type="string", length=255, nullable=false)
     */
    private $contenuSignal;

    /**
     * @var string
     *
     * @ORM\Column(name="type_signal", type="string", length=30, nullable=false)
     */
    private $typeSignal;

    /**
     * @var string
     *
     * @ORM\Column(name="etat_signal", type="string", length=30, nullable=false)
     */
    private $etatSignal;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_signal", type="date", nullable=false, options={"default"="CURRENT_TIMESTAMP"})
     */
    private $dateSignal = 'CURRENT_TIMESTAMP';

    /**
     * @var \Postes
     *
     * @ORM\ManyToOne(targetEntity="Postes")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_post", referencedColumnName="id_post")
     * })
     */
    private $idPost;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_user", referencedColumnName="id_user")
     * })
     */
    private $idUser;

    public function getIdSignal(): ?int
    {
        return $this->idSignal;
    }

    public function getContenuSignal(): ?string
    {
        return $this->contenuSignal;
    }

    public function setContenuSignal(string $contenuSignal): self
    {
        $this->contenuSignal = $contenuSignal;

        return $this;
    }

    public function getTypeSignal(): ?string
    {
        return $this->typeSignal;
    }

    public function setTypeSignal(string $typeSignal): self
    {
        $this->typeSignal = $typeSignal;

        return $this;
    }

    public function getEtatSignal(): ?string
    {
        return $this->etatSignal;
    }

    public function setEtatSignal(string $etatSignal): self
    {
        $this->etatSignal = $etatSignal;

        return $this;
    }

    public function getDateSignal(): ?\DateTimeInterface
    {
        return $this->dateSignal;
    }

    public function setDateSignal(\DateTimeInterface $dateSignal): self
    {
        $this->dateSignal = $dateSignal;

        return $this;
    }

    public function getIdPost(): ?Postes
    {
        return $this->idPost;
    }

    public function setIdPost(?Postes $idPost): self
    {
        $this->idPost = $idPost;

        return $this;
    }

    public function getIdUser(): ?User
    {
        return $this->idUser;
    }

    public function setIdUser(?User $idUser): self
    {
        $this->idUser = $idUser;

        return $this;
    }


}
