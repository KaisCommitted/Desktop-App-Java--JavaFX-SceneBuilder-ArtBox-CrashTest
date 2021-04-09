<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * User
 *
 * @ORM\Table(name="user")
 * @ORM\Entity(repositoryClass="App\Repository\UserRepository")
 */
class User
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_user", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idUser;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=255, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="prenom", type=fr"string", length=255, nullable=false)
     */
    private $prenom;

    /**
     * @var string
     *
     * @ORM\Column(name="username", type="string", length=255, nullable=false)
     */
    private $username;

    /**
     * @var string
     *
     * @ORM\Column(name="mail", type="string", length=255, nullable=false)
     */
    private $mail;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_naissance", type="date", nullable=false)
     */
    private $dateNaissance;

    /**
     * @var string
     *
     * @ORM\Column(name="pwd_user", type="string", length=255, nullable=false)
     */
    private $pwdUser;

    /**
     * @var string
     *
     * @ORM\Column(name="ref_admin", type="string", length=1, nullable=false)
     */
    private $refAdmin;

    /**
     * @var int|null
     *
     * @ORM\Column(name="id_label", type="integer", nullable=true)
     */
    private $idLabel;

    public function getIdUser(): ?int
    {
        return $this->idUser;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    public function getPrenom(): ?string
    {
        return $this->prenom;
    }

    public function setPrenom(string $prenom): self
    {
        $this->prenom = $prenom;

        return $this;
    }

    public function getUsername(): ?string
    {
        return $this->username;
    }

    public function setUsername(string $username): self
    {
        $this->username = $username;

        return $this;
    }

    public function getMail(): ?string
    {
        return $this->mail;
    }

    public function setMail(string $mail): self
    {
        $this->mail = $mail;

        return $this;
    }

    public function getDateNaissance(): ?\DateTimeInterface
    {
        return $this->dateNaissance;
    }

    public function setDateNaissance(\DateTimeInterface $dateNaissance): self
    {
        $this->dateNaissance = $dateNaissance;

        return $this;
    }

    public function getPwdUser(): ?string
    {
        return $this->pwdUser;
    }

    public function setPwdUser(string $pwdUser): self
    {
        $this->pwdUser = $pwdUser;

        return $this;
    }

    public function getRefAdmin(): ?string
    {
        return $this->refAdmin;
    }

    public function setRefAdmin(string $refAdmin): self
    {
        $this->refAdmin = $refAdmin;

        return $this;
    }

    public function getIdLabel(): ?int
    {
        return $this->idLabel;
    }

    public function setIdLabel(?int $idLabel): self
    {
        $this->idLabel = $idLabel;

        return $this;
    }
    public function __toString()
    {
        return $this->username;
    }

}
