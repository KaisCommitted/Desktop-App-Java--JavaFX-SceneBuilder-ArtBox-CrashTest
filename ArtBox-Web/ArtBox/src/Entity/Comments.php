<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Comments
 *
 * @ORM\Table(name="comments", indexes={@ORM\Index(name="id_post2", columns={"id_post"}), @ORM\Index(name="id_use2", columns={"id_user"})})
 * @ORM\Entity(repositoryClass="App\Repository\CommentsRepository")
 */
class Comments
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_comment", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idComment;

    /**
     * @var string
     *
     * @ORM\Column(name="comment", type="string", length=100, nullable=false)
     */
    private $comment;

    /**
     * @var string
     *
     * @ORM\Column(name="comment_analys", type="string", length=255, nullable=false)
     */
    private $commentAnalys;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="comment_date", type="datetime", nullable=false, options={"default"="CURRENT_TIMESTAMP"})
     */
    private $commentDate = 'CURRENT_TIMESTAMP';

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

    public function getIdComment(): ?int
    {
        return $this->idComment;
    }

    public function getComment(): ?string
    {
        return $this->comment;
    }

    public function setComment(string $comment): self
    {
        $this->comment = $comment;

        return $this;
    }

    public function getCommentAnalys(): ?string
    {
        return $this->commentAnalys;
    }

    public function setCommentAnalys(string $commentAnalys): self
    {
        $this->commentAnalys = $commentAnalys;

        return $this;
    }

    public function getCommentDate(): ?\DateTimeInterface
    {
        return $this->commentDate;
    }

    public function setCommentDate(\DateTimeInterface $commentDate): self
    {
        $this->commentDate = $commentDate;

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
