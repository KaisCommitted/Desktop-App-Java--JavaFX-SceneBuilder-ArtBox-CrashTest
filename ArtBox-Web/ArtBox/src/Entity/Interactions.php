<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Interactions
 *
 * @ORM\Table(name="interactions", indexes={@ORM\Index(name="fk_uppppp", columns={"id_post"}), @ORM\Index(name="fk_ussssss", columns={"id_user"})})
 * @ORM\Entity(repositoryClass="App\Repository\InteractionsRepository")
 */
class Interactions
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_inter", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idInter;

    /**
     * @var int
     *
     * @ORM\Column(name="like_check", type="integer", nullable=false)
     */
    private $likeCheck;

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

    public function getIdInter(): ?int
    {
        return $this->idInter;
    }

    public function getLikeCheck(): ?int
    {
        return $this->likeCheck;
    }

    public function setLikeCheck(int $likeCheck): self
    {
        $this->likeCheck = $likeCheck;

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
