<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Annonce
 *
 * @ORM\Table(name="annonce", indexes={@ORM\Index(name="fk_userrrrr", columns={"id_user"}), @ORM\Index(name="cattt", columns={"categorie"})})
 * @ORM\Entity(repositoryClass="App\Repository\AnnonceRepository")
 */
class Annonce
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_ann", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idAnn;

    /**
     * @var string
     *
     * @ORM\Column(name="titre_ann", type="string", length=250, nullable=false)
     */
    private $titreAnn;

    /**
     * @var string
     *
     * @ORM\Column(name="desc_ann", type="string", length=250, nullable=false)
     */
    private $descAnn;

    /**
     * @var int
     *
     * @ORM\Column(name="pay", type="integer", nullable=false)
     */
    private $pay;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="ddl_ann", type="date", nullable=false)
     */
    private $ddlAnn;

    /**
     * @var \Categorie
     *
     * @ORM\ManyToOne(targetEntity="Categorie")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="categorie", referencedColumnName="categorie_name")
     * })
     */
    private $categorie;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_user", referencedColumnName="id_user")
     * })
     */
    private $idUser;

    public function getIdAnn(): ?int
    {
        return $this->idAnn;
    }

    public function getTitreAnn(): ?string
    {
        return $this->titreAnn;
    }

    public function setTitreAnn(string $titreAnn): self
    {
        $this->titreAnn = $titreAnn;

        return $this;
    }

    public function getDescAnn(): ?string
    {
        return $this->descAnn;
    }

    public function setDescAnn(string $descAnn): self
    {
        $this->descAnn = $descAnn;

        return $this;
    }

    public function getPay(): ?int
    {
        return $this->pay;
    }

    public function setPay(int $pay): self
    {
        $this->pay = $pay;

        return $this;
    }

    public function getDdlAnn(): ?\DateTimeInterface
    {
        return $this->ddlAnn;
    }

    public function setDdlAnn(\DateTimeInterface $ddlAnn): self
    {
        $this->ddlAnn = $ddlAnn;

        return $this;
    }

    public function getCategorie(): ?Categorie
    {
        return $this->categorie;
    }

    public function setCategorie(?Categorie $categorie): self
    {
        $this->categorie = $categorie;

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
