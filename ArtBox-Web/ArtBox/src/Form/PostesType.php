<?php

namespace App\Form;

use App\Entity\Postes;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class PostesType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('description')
            ->add('nomPost')
            ->add('file')
            ->add('postDate')
            ->add('albumCover')
            ->add('likes')
            ->add('descAnalys')
            ->add('postType')
            ->add('categorie')
            ->add('idUser')
        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Postes::class,
        ]);
    }
}
