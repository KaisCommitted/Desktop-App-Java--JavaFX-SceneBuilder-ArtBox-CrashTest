<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Evenement
 *
 * @ORM\Table(name="evenement", indexes={@ORM\Index(name="ssss", columns={"type_event"}), @ORM\Index(name="id_org", columns={"id_org"}), @ORM\Index(name="categorie", columns={"categorie"})})
 * @ORM\Entity(repositoryClass="App\Repository\EvenementRepository")
 */
class Evenement
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date", type="date", nullable=false)
     */
    private $date;

    /**
     * @var string
     *
     * @ORM\Column(name="nom_event", type="string", length=255, nullable=false)
     */
    private $nomEvent;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=255, nullable=false)
     */
    private $description;

    /**
     * @var int
     *
     * @ORM\Column(name="capacite_event", type="integer", nullable=false)
     */
    private $capaciteEvent;

    /**
     * @var int
     *
     * @ORM\Column(name="nb_max", type="integer", nullable=false)
     */
    private $nbMax = '0';

    /**
     * @var string
     *
     * @ORM\Column(name="image_event", type="string", length=255, nullable=false)
     */
    private $imageEvent;

    /**
     * @var string|null
     *
     * @ORM\Column(name="location_event", type="string", length=255, nullable=true)
     */
    private $locationEvent;

    /**
     * @var int|null
     *
     * @ORM\Column(name="rating_event", type="integer", nullable=true)
     */
    private $ratingEvent = '0';

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
     * @var \TypeEvent
     *
     * @ORM\ManyToOne(targetEntity="TypeEvent")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="type_event", referencedColumnName="type_name")
     * })
     */
    private $typeEvent;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_org", referencedColumnName="id_user")
     * })
     */
    private $idOrg;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getDate(): ?\DateTimeInterface
    {
        return $this->date;
    }

    public function setDate(\DateTimeInterface $date): self
    {
        $this->date = $date;

        return $this;
    }

    public function getNomEvent(): ?string
    {
        return $this->nomEvent;
    }

    public function setNomEvent(string $nomEvent): self
    {
        $this->nomEvent = $nomEvent;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): self
    {
        $this->description = $description;

        return $this;
    }

    public function getCapaciteEvent(): ?int
    {
        return $this->capaciteEvent;
    }

    public function setCapaciteEvent(int $capaciteEvent): self
    {
        $this->capaciteEvent = $capaciteEvent;

        return $this;
    }

    public function getNbMax(): ?int
    {
        return $this->nbMax;
    }

    public function setNbMax(int $nbMax): self
    {
        $this->nbMax = $nbMax;

        return $this;
    }

    public function getImageEvent(): ?string
    {
        return $this->imageEvent;
    }

    public function setImageEvent(string $imageEvent): self
    {
        $this->imageEvent = $imageEvent;

        return $this;
    }

    public function getLocationEvent(): ?string
    {
        return $this->locationEvent;
    }

    public function setLocationEvent(?string $locationEvent): self
    {
        $this->locationEvent = $locationEvent;

        return $this;
    }

    public function getRatingEvent(): ?int
    {
        return $this->ratingEvent;
    }

    public function setRatingEvent(?int $ratingEvent): self
    {
        $this->ratingEvent = $ratingEvent;

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

    public function getTypeEvent(): ?TypeEvent
    {
        return $this->typeEvent;
    }

    public function setTypeEvent(?TypeEvent $typeEvent): self
    {
        $this->typeEvent = $typeEvent;

        return $this;
    }

    public function getIdOrg(): ?User
    {
        return $this->idOrg;
    }

    public function setIdOrg(?User $idOrg): self
    {
        $this->idOrg = $idOrg;

        return $this;
    }


}
