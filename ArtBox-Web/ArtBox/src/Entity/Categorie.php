<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Categorie
 *
 * @ORM\Table(name="categorie")
 * @ORM\Entity(repositoryClass="App\Repository\CategorieRepository")
 */
class Categorie
{
    /**
     * @var string
     *
     * @ORM\Column(name="categorie_name", type="string", length=255, nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $categorieName;

    public function getCategorieName(): ?string
    {
        return $this->categorieName;
    }
    
    public function setCategorieName(string $categorieName): self
    {
        $this->categorieName = $categorieName;

        return $this;
    }
    public function __toString()
    {
        return $this->categorieName;
    }


}
